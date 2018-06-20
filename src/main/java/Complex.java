/**
 * Complex class file
 */



/**
 * Immutable complex class
 * This class is adapted from J. Bloch Book : "Effective Java 2nd edition" Addison-Wesley Professional
 * @author J. Bloch
 * @author D. Arrivault
 */
public final class Complex {
	
	private final double re;
	private final double im;
	
	public Complex(double re, double im){
		this.re = re;
		this.im = im;
	}
	
	/**
	 * Accessor on real part
	 * @return double real part
	 */
	public double realPart(){return re;}
	/**
	 * Accessor on imaginary part
	 * @return double imaginary part
	 */
	public double imaginaryPart(){return im;}
	
	/**
	 * Arithmetic operator : addition
	 * @param c complex to add to this
	 * @return Complex this + c
	 */
	public Complex add(Complex c){
		return new Complex(re + c.re, im + c.im);
	}
	
	/**
	 * Arithmetic operator : substraction
	 * @param c complex to substract from this
	 * @return Complex this - c
	 */
	public Complex subtract(Complex c){
		return new Complex(re - c.re, im - c.im);
	}
	
	/**
	 * Arithmetic operator : multiplication
	 * @param c complex to multiply by this
	 * @return Complex this * c
	 */
	public Complex multiply(Complex c){
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}
	
	/**
	 * Arithmetic operator : division
	 * @param c complex that divides this
	 * @return Complex this / c
	 */
	public Complex divide(Complex c){
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp,
				(im * c.re - re * c.im) / tmp);
	}

	@Override 
	public boolean equals(Object o){
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;
		return Double.compare(re, c.re)== 0 &&
				Double.compare(im, c.im) == 0;
		
	}
	
	@Override
	public int hashCode(){
		int result = 17 + hashDouble(re);
		result = 31 * result + hashDouble(im);
		return result;
	}
	
	private static int hashDouble(double val){
		long longBits = Double.doubleToLongBits(val);
		return (int) (longBits ^ (longBits >>> 32));
	}
	

	@Override
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}
	
	/**
	 * Return the conjugate of this
	 * @return Complex cojugate of this
	 */
	public Complex conj(){
		return new Complex(re,-im);
	}
}
