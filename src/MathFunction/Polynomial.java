package MathFunction;

import java.lang.RuntimeException;

public class Polynomial implements MathFunction
{

	private double[] coefficients;

	public int getOrder () { return this.coefficients.length + 1; }

	// todo: (0,3,0) input
	public Polynomial ( double[] newCoefficients )
	{
		this.coefficients = new double[ newCoefficients.length ];
		System.arraycopy(newCoefficients, 0, coefficients, 0, newCoefficients.length);
	}

	public double[] getCoefficients () { return this.coefficients; }

	public String toString ()
 	{
		// use stringbuilder???
		return "Poly:" + this.coefficients[0];
	}

	public double evaluate ( double x )
	{
		double sum = 0;
		for ( int i = 0; i < coefficients.length; i++ )
		{
			sum += Math.pow(x,i) * coefficients[i];
		}
		return sum;
	}

	public MathFunction differentiate ()
	{
		int len = this.coefficients.length - 1;
		double[] newCoefficients = new double[ len ];

		for ( int i = 1; i <= len; i ++)
		{
			newCoefficients[i-1] = this.coefficients[i]*i;
		}

		return new Polynomial( newCoefficients );
	}

	public MathFunction differentiate ( int n )
	{
		if ( n >= this.coefficients.length )
			return new Polynomial ( new double[]{0.0} );

		int len = this.coefficients.length - n;
		double[] newCoefficients = new double[ len ];
		int factor = factorial(n);

		for ( int i = n; i <= len; i ++)
		{
			newCoefficients[i-n] = this.coefficients[i]*factor;
			factor = factor * (i+1) / (i-n);
		}

		return new Polynomial( newCoefficients );
	}

	private int factorial ( int n )
	{
		if ( n < 0 )
			throw new RuntimeException("Factorial of negative number used - use the gamma function instead");

		int prod = 1;
		for ( int i = 2; i <= n; i ++ )
			prod *= i;
		return prod;
	}

}
