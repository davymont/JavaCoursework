import java.util.Scanner;

public class testQuadEq
{
	public static void main(String[] args)
	{
		Scanner inp = new Scanner(System.in);
		System.out.print("a: ");
		int a = inp.nextInt();
		System.out.print("b: ");
		int b = inp.nextInt();
		System.out.print("c: ");
		int c = inp.nextInt();
		QuadraticEquation e1 = new QuadraticEquation(a, b, c);
		System.out.println(e1.roots());
	}
}