import java.util.Scanner;

public class Date implements Comparable, Cloneable, java.io.Serializable {
   
    private int day;
    private int month;
    private int year;
    private boolean monthExplicitMode = false;
	private final static long serialVersionUID = 0;

    private static String[] monthNames = {"NA", "January", "February", "March",
					  "April", "May", "June", "July",
                                          "August", "September", "October", 
                                          "November", "December"};



    public Date(int month, int day, int year) throws DateException
    {
        checkParameters(month, day, year);
	this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(int month, int day, int year, boolean monthExplicitMode) throws DateException
    {
        checkParameters(month, day, year);
	this.month = month;
        this.day = day;
        this.year = year;
        this.monthExplicitMode = monthExplicitMode;
    }

    /** Uses clone of Object class as all the fields are primitive*/        
    public Object clone()
    {
	try 
        {
          return new Date(month, day, year);
        }
        catch(DateException e)
	{ // Not expected to reach this point
          // If for some reason it reaches, then a runtime error will be thrown
	    assert false;  
	}    
        return null;
    }


    /** Compares this and the o object and 
      * returns -1 if this < o,
      * returns 0 if this is equivalent to o
      * returns 1 if this > o
      */
    public int compareTo(Object o)
    {
	Date d = (Date)o;
        if (equals(d)) 
           return 0;
        else if (year < d. year)
	    return -1;
        else if (year > d.year)
            return 1;
        else if (month < d.month)
            return -1;
        else if (month > d.month)
	    return 1;
        else if (day < d.day)
            return -1;
        else // day > d.day
	    return 1;  
    }


    private void checkParameters(int month, int day, int year) throws DateException
    {
        String message = "Problems: \n";
        if (month < 1)
           message += " \t* Month cannot be smaller than 1\n";
        else if (month > 12)
           message += " \t* Month cannot be bigger than 12\n";   
        if (day < 1) 
           message += " \t* Day cannot be smaller than 1\n";
        else if (day > 31) 
           message += " \t* Day cannot be bigger than 31\n";           
        if (year < 0)
           message += " \t* Year cannot be a negative value\n";
           
        if (month < 1 || month > 12 || day < 1 || day > 31 || year < 0)   
           throw new DateException(message);      
    }  

    public int getDay() { return day; }
    
    public int getMonth() { return month; }

    public int getYear() { return year; }

    public void setDay(int day) { this.day = day; }
 
    public void setMonth(int month) { this.month = month; }

    public void setYear(int year) { this.year = year; } 

    public boolean isMonthExplicitMode() { return monthExplicitMode; }
 
    public void setMonthMode(boolean mode) { monthExplicitMode = mode;}

    public String toString() 
    {
	if (monthExplicitMode)
	{
	    String daySuffix = "th";
            if (day % 10 == 1 && day != 11)
               daySuffix = "st";  
            else if (day % 10 == 2 && day != 12)
               daySuffix = "nd";  
            else if (day % 10 == 3 && day != 13)
               daySuffix = "rd";

            return monthNames[month] + " " + day + daySuffix + ", " + year;
	}   
        else return ((month < 10) ? "0" + month : month) + "/" +
		 ((day < 10) ? "0" + day : day) + "/" + 
                 (((year % 100) < 10) ? "0" + (year % 100) : (year % 100));
    }

    public boolean equals(Date other)
    {
	return (month == other.month && day == other.day && year == other.year);
    }

    public static void main(String[] args)
    {
    
      boolean goesFine = true;
      
      try {

        Scanner input = new Scanner(System.in);
        
        // Below in useDelimiter, / is for recognizing m/d/y format 
        // \\s means any whitespace that Java normally recognizes
        // [somestring]+ means any combinations of the characters in somestring 
        // that is length one or more
        input.useDelimiter("[/\\s]+");
        System.out.println("Please enter date in m/d/y format");
        
                
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
         
        Date someDay = new Date(month, day, year);

     }
     catch(DateException e)
     {
       goesFine = false;
       System.out.println(e);
     }       
     catch(Exception e)
     {
       goesFine = false;     
       System.out.println("Some other exception " + e);
     }
     finally {
       if (goesFine)
          System.out.println("Bye!");
       else 
          System.out.println("Please try again with correct input");   
     }

   
    }
   
}
