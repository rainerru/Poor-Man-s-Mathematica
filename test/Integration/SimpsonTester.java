package Integration;

import MathFunction.MathFunction;
import MathFunction.*;

public class SimpsonTester
{

	public static void main ( String[] args )
	{
		Integrator int1 = new SimpsonIntegrator();
		MathFunction f = new Polynomial( new double[]{2,1,5} );

		double res = int1.integrate(f,1,3,0.001);

		System.out.println("Define f(x) = 5x^2 + x + 2");
		System.out.println("Evaluating f at 0, 1 and 2 gives "
			+ f.evaluate(0) + ", "
			+ f.evaluate(1) + ", "
			+ f.evaluate(2));
		System.out.println("Integrating f over [1,3] gives " + res);
	}

}
