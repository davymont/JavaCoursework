import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;

public class EventBinaryIO {
	public static void main(String[] args)
	{
		String textInputFileName = args[0];
		String binaryFileName = args[1];
		File textIn = null;
		textIn = new File(textInputFileName);
		
		try {
			Scanner in = new Scanner(textIn);
			String eventName = "";
			Event currEvent;
			int eventMonth = 0;
			int eventDay = 0;
			int eventYear = 0;
			in.useDelimiter("[/\\s]+");

			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binaryFileName));
				
				while(in.hasNext()) {
					eventName = in.nextLine();
					eventMonth = in.nextInt();
					eventDay = in.nextInt();
					eventYear = in.nextInt();
					currEvent = new Event(eventName, eventMonth, eventDay, eventYear);
					System.out.println("Writing "+eventName+" on "+eventMonth+"/"+eventDay+"/"+eventYear+" in binary");
					oos.writeObject(currEvent);
					in.nextLine();
				}		
				oos.close();
			} catch(Exception e) { System.out.println("Reading in binary..."); }
		} catch(Exception e) { System.out.println("File not found."); }
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binaryFileName));
			while(true) {
				try {
				Event current = (Event)ois.readObject();
				System.out.println(current); }
				catch (EOFException e) { ois.close(); break; }
			}
		} catch(Exception e) { System.out.println("File not found."); }
	}
}