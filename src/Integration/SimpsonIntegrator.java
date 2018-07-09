package Integration;

import MathFunction.MathFunction;
import Integration.*;

public class SimpsonIntegrator implements Integrator
{

	public double integrate ( MathFunction f, double a, double b, double prec )
	{
		int step = 0;
		int parts = 2;
		double thisSolution = this.integrate( f, a, b, 1);
		double nextSolution = this.integrate( f, a, b, 2);
		while ( Math.abs( nextSolution - thisSolution ) >= prec )
		{
			step++;
			if ( step >= 30 )
				return nextSolution; // throw Exception, but just a warning
			thisSolution = nextSolution;
			parts = parts * 2;
			nextSolution = this.integrate( f, a, b, parts);
		}
		return nextSolution;
	}

	public double integrate ( MathFunction f, double a, double b, int numOfIntervals )
	{
		double sum = 0;
		double localSum = 0;
		double[] points = generatePoints( numOfIntervals, a, b );
		for ( int i = 0; i < points.length-1; i++ )
		{
			localSum = f.evaluate( points[i] ); 
			localSum += 4*f.evaluate( ( points[i] + points[i+1] )/2 ); 
			localSum += f.evaluate( points[i+1] );
			sum += localSum*( points[i+1] - points[i] )/6;
		}
		return sum;
	}

	public double integrate ( MathFunction f, double a, double b )
	{
		return this.integrate( f, a, b, 0.0001 );
	}

	public double[] generatePoints( int n, double a, double b ) // oder double prec
	{
		double[] points = new double[n+1];
		double t;
		for ( int i = 0; i <= n; i++ )
		{
			t = ( (double) i ) / n;
			points[i] = a*(1-t) + b*t;
		}
		return points;
	}

}
