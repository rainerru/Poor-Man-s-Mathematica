package Integration;

import MathFunction.MathFunction;

public interface Integrator
{

	double integrate ( MathFunction f, double a, double b );

	double integrate ( MathFunction f, double a, double b, int numOfIntervals );

	double integrate ( MathFunction f, double a, double b, double precision );

}
