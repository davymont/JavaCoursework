/*
Declare a two-dimensional array which can be used to store a yearly budget. 
Each column of the array corresponds to a particular budgeted item such as rent, phone bill, etc.  
There are a total of 6 items need to be budgeted. 
Each row of the array corresponds to a month, January, February, ..., till December.  
You can initialize this array as some reasonable random numbers 
(such as: rent should be the same across all months, while food can vary from 300-800). 

Write a method takes this budget table as an input and returns how much money you need for next year. 
Write another method that also takes this budget table as an input, but returns an array with how much money you may spend for each month.  
Also another method for getting the month during which you may spend the most money.
*/

import java.lang.Math;

public class budgePlan
{
	public static void main(String[] args)
	{
		int[][] budget = new int[12][6];
		//col 1 = rent
		//col 2 = food
		//col 3 = car payment
		//col 4 = internet
		//col 5 = cell phone plan
		//col 6 = utilities
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String[] payments = {"Rent","Food","Car","Web","Phone","Utilities"};
		
		for(int x = 0; x < budget.length; x++)
		{
			//rent
			budget[x][0] = 870;
			//food
			budget[x][1] = (int)((Math.random()*501)+300);
			//car payment
			budget[x][2] = 240;
			//internet
			budget[x][3] = 110;
			//cell phone plan
			budget[x][4] = 180;
			//utilities
			budget[x][5] = 215;
		}
		
		System.out.print("\t");
		for(int x = 0; x < payments.length; x++)
		{
			System.out.print(payments[x] + "\t");
		}
		
		System.out.println("\n\t_________________________________________________");
		
		for(int x = 0; x < budget.length; x++)
		{
			System.out.println();
			System.out.print(months[x].substring(0, 3)+"\t");
			for(int y = 0; y < budget[x].length; y++)
			{
				System.out.print("$"+budget[x][y]+"\t");
			}
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Your total budget for the year is $"+totalBudget(budget));
		System.out.println();
		
		System.out.println("Your monthly spending is as follows");
		for(int x = 0; x < months.length; x++)
		{
			System.out.println(months[x].substring(0,3)+": $"+monthlySpending(budget, x));
		}
		System.out.println();
		
		System.out.println("You spend the most money in the month of "+months[expensiveMonth(budget)]+".");
	}
	
	public static int totalBudget(int[][] a)
	{
		int total = 0;
		for(int x = 0; x < a.length; x++)
		{
			for(int y = 0; y < a[x].length; y++)
				total += a[x][y];
		}
		return total;
	}
	
	public static int monthlySpending(int[][] a, int b)
	{
		int total = 0;
		for(int y = 0; y < a[0].length; y++)
			total += a[b][y];
		return total;
	}

	public static int expensiveMonth(int[][] a)
	{
		int month = 0;
		int max = 0;
		int index = 0;
		for(int x = 0; x < a.length; x++)
		{
			month = 0;
			for(int y = 0; y < a[0].length; y++)
			{
				month += a[x][y];
			}
			if(month > max)
			{
				max = month;
				index = x;
			}
		}
		return index;
	}
}