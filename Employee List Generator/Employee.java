public class Employee
{
	private String fName;
	private String mName;
	private String lName;
	private String ID;
	private String title;
	private String startDate;
	
	public Employee()
	{
		fName = ""; mName = ""; lName = ""; ID = ""; title = ""; startDate = "";
	}
	
	public void setNames(String name)
	{
		int spaces = 0;
		String trimName;
		for(int i = 0; i < name.length(); i++)
		{
			if(name.charAt(i) == ' ')
				spaces++;
		}
		
		//spaces = 1, first and last name
		//spaces = 2, first, middle, and last name
		if(spaces == 0||spaces > 2)
		{
			errorM(1);
		}
		else
		{
			fName = name.substring(0, (name.indexOf(' ')));
			trimName = name.substring((name.indexOf(' ')+1), name.length());
			if(spaces == 2)
			{
				mName = trimName.substring(0, (trimName.indexOf(' ')));
				trimName = trimName.substring((trimName.indexOf(' ')+1), trimName.length());
			}
			lName = trimName.substring(0, trimName.length());
		}
	}
	
	public void setID(String id)
	{
		boolean allNums = true;
	
		//checks that id is of a valid length
		if(id.length() != 11)
		{
			errorM(2);
		}
		//checks that all dashes are in the correct location
		else if(id.charAt(3) != '-' || id.charAt(6) != '-')
		{
			errorM(2);
		}
		else
		{
			//checks that all characters not dashes are numbers
			for(int i = 0; i < id.length(); i++)
			{
				if(i == 3 || i == 6)
				{
					continue;
				}
				if(!checkNum(id.charAt(i)))
				{
					allNums = false;
				}
			}
			if(allNums)
			{
				ID = id;
			}
			else
			{
				errorM(2);
			}
		}
	}
	
	public void setTitle(String t)
	{
		if(t.equals("Director")||t.equals("Analyst")||t.equals("Programmer"))
			title = t;
		else
			errorM(3);
	}
	
	public void setStartDate(String date)
	{
		String trim;
		
		if(date.length() != 10&&date.length() != 9&&date.length() != 8)
		{
			errorM(4);
		}
		else if(date.length() == 10 && (date.charAt(2) != '/' || date.charAt(5) != '/'))
		{
			errorM(4);
		}
		else if(date.length() == 8 && (date.charAt(1) != '/' || date.charAt(3) != '/'))
		{
			errorM(4);
		}
		else if((date.length() == 9 && (date.charAt(1) != '/' && date.charAt(4) != '/')) || (date.length() == 9 && (date.charAt(2) != '/' && date.charAt(4) != '/')))
		{
			errorM(4);
		}
		else
		{
			int month = Integer.parseInt(date.substring(0, date.indexOf('/')));
			trim = date.substring((date.indexOf('/')+1), date.length());
			int day = Integer.parseInt(trim.substring(0, trim.indexOf('/')));
			trim = trim.substring((trim.indexOf('/')+1), trim.length());
			int year = Integer.parseInt(trim.substring(0, trim.length()));
			
			if(!m(month) || !d(day) || !y(year))
			{
				errorM(4);
			}
			else
				startDate = date;
		}
	}
	
	public String getfName()
	{
		return fName;
	}
	
	public String getmName()
	{
		return mName;
	}
	
	public String getlName()
	{
		return lName;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getDate()
	{
		return startDate;
	}
	
	public String toString()
	{
		if(mName != null)
			return "Name: " + getlName() + ", " + getfName() + " " + getmName() + "\nTitle: " + getTitle() + "\nID: " + getID() + "\nStarting Date: " + getDate();
		else
			return "Name: " + getlName() + ", " + getfName() + "\nTitle: " + getTitle() + "\nID: " + getID() + "\nStarting Date: " + getDate();
	}
	
	public static boolean checkNum(char x)
	{
		return x == '0' || x == '1' || x == '2' || x == '3' || x == '4' ||x == '5' || x == '6' ||x == '7' || x == '8' ||x == '9';
	}
	
	public static boolean m(int x)
	{
		return x == 1 || x == 2|| x == 3|| x == 4|| x == 5|| x == 6|| x == 7|| x == 8|| x == 9|| x == 10|| x == 11|| x == 12;
	}
	
	public static boolean d(int x)
	{
		return x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7 || x == 8 || x == 9 || x == 10 || x == 11 || x == 12 || x == 13 || x == 14 || x == 15 || x == 16 || x == 17 || x == 18 || x == 19 || x == 20 || x == 21 || x == 22 || x == 23 || x == 24 || x == 25 || x == 26 || x == 27 || x == 28 || x == 29 || x == 30 || x == 31;
	}
	
	public static boolean y(int x)
	{
		if((x / 1000 != 1)&&(x / 1000 != 2))
		{
			return false;
		}
		else
			return true;
 	}
	
	public static void errorM(int id)
	{
		System.out.print("Whoops! You supplied an invalid ");
		switch(id)
		{
			case 1:
				System.out.println("name.");
				break;
			case 2:
				System.out.println("ID.");
				break;
			case 3:
				System.out.println("title.");
				break;
			case 4:
				System.out.println("date.");
				break;
			default:
				System.out.println("value for some field.");
				break;
		}
	}
}