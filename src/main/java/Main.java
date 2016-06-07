package main.java;

public class Main {

	public static void main(String[] args) {
		Complex c1 = new Complex(2,4);
		Complex c2 = new Complex(1,2);
		System.out.println(c1.divide(c2));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c2.add(c2)));
	}

}
