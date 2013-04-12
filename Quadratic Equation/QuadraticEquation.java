import java.lang.Math;

public class QuadraticEquation
{
	private int a;
	private int b;
	private int c;
	
	public QuadraticEquation(int x, int y, int z)
	{
		a = x;
		b = y;
		c = z;
	}
	
	public int getA()
	{
		return this.a;
	}
	
	public int getB()
	{
		return this.b;
	}
	
	public int getC()
	{
		return this.c;
	}
	
	public double getDiscriminant()
	{
		return ((b*b)-(4*a*c));
	}
	
	public String roots()
	{
		String ret = "Root 1: ";
		if(getDiscriminant() >= 0)
		{
			ret += getRoot1();
			if(getDiscriminant() > 0)
			{
				ret+= "\nRoot 2: "+getRoot2();
			}
			return ret;
		}
		else
		return "There are no real roots for the equation.";
	}
	
	public double getRoot1()
	{
		return (((-b)+Math.sqrt(getDiscriminant()))/(2*a));
	}
	
	public double getRoot2()
	{
		return (((-b)-Math.sqrt(getDiscriminant()))/(2*a));
	}
}