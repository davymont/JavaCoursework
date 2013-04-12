
public class Event implements Cloneable, java.io.Serializable
{
    private String name;
    private Date date;
	private final static long serialVersionUID = 0;

    public Event(String name, int month, int day, int year) throws DateException
    {
	this.name = name;
        date = new Date(month, day, year); 
    }

    public Event(String name, Date date) 
    {
        // Although name is not a primitive value, it is an immutable object
        // So it is fine to copy it 
	this.name = name;
        // Since date is a reference, we make a separate copy of it and 
        // make this.date point to that copy 
        this.date = (Date)date.clone();
    }

    public void changeDate(int month, int day, int year)
    {
        date.setMonth(month);
        date.setDay(day);
        date.setYear(year);
    }

    public String toString()
    {
	return name + " on " + date;  
    }

    public Object clone() 
    {

        return new Event(name, date); 
    }

    public static void main(String[] args)
    {
       try 
       {
   	 Date date1 = new Date(2, 13, 2013);
         Event e1 = new Event("Doctor's Appointment",date1);
         Event e2 = new Event("HW Due Date", date1);
         System.out.println("My appointments:");
         System.out.println(e1);
         System.out.println(e2);
         e2.changeDate(2, 20, 2013);
         System.out.println("Yay! HW Due Date Extended:");
         System.out.println(e1);
         System.out.println(e2);
       }
       catch(DateException e)
       {
       }  
    }

}