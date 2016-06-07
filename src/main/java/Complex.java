/**
 * Complex class file
 */
package main.java;


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
	
	//Accessors without mutator
	public double realPart(){return re;}
	public double imaginaryPart(){return im;}
	
	//Arithmetic operators
	public Complex add(Complex c){
		return new Complex(re + c.re, im + c.im);
	}
	
	public Complex subtract(Complex c){
		return new Complex(re - c.re, im - c.im);
	}
	
	public Complex multiply(Complex c){
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}
	
	public Complex divide(Complex c){
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp,
				(im * c.re - re * c.im) / tmp);
	}

	//Comparison operator
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
	
	//Display
	@Override
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}
	
	//Conjugate
	public Complex conj(){
		return new Complex(re,-im);
	}
}
