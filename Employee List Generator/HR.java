import java.util.Scanner;
import java.io.*;

public class HR
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		Scanner input = new Scanner(file);
		int spaces = 0;
		int counter;
		String tempEmp;
		String name, title, id, date, trim;
		name = " ";
		title = " ";
		id = " ";
		date = " ";
		
		File myFile = new File("newEmpList.txt");
		PrintWriter out = new PrintWriter(new FileWriter(myFile));
		
		int i = Integer.parseInt(input.nextLine());
		Employee[] eList = new Employee[i];
		
		for(int x = 0; x < eList.length; x++)
		{
			eList[x] = new Employee();
		}
		
		int count = 0;
		while(count < i)
		{
			spaces = 0;
			tempEmp = input.nextLine();
			
			for(int x = 0; x < tempEmp.length(); x++)
			{
				if(tempEmp.charAt(x) == ' ')
					spaces++;
			}
			
			counter = 0;
			int[] spacelist = new int[spaces];
			for(int x = 0; x < tempEmp.length(); x++)
			{
				if(tempEmp.charAt(x) == ' ')
				{
					spacelist[counter] = x;
					counter++;
				}
			}
			
			//4 spaces is no mname
			//5 spaces is mname
			
			if(spaces == 4)
			{
				name = tempEmp.substring(0, spacelist[1]);
				title = tempEmp.substring(spacelist[1]+1, spacelist[2]);
				id = tempEmp.substring(spacelist[2]+1, spacelist[3]);
				date = tempEmp.substring(spacelist[3]+1, tempEmp.length());
				
			}
			else if(spaces == 5)
			{
				name = tempEmp.substring(0, spacelist[2]);
				title = tempEmp.substring(spacelist[2]+1, spacelist[3]);
				id = tempEmp.substring(spacelist[3]+1, spacelist[4]);
				date = tempEmp.substring(spacelist[4]+1, tempEmp.length());
			}
			
			eList[count].setNames(name);
			eList[count].setTitle(title);
			eList[count].setID(id);
			eList[count].setStartDate(date);
			
			count++;
		}
		
		for(int x = 0; x < eList.length; x++)
		{
			out.println(eList[x]);
			out.println("");
		}
		
		out.println("");
		out.println("Thanks for a great semester! :)");
		
		out.close();
	}
}