import java.io.*;
import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		try {
			Scanner file = new Scanner( new File("text.txt"));
			int outgoing_traffic = 0;
			
			while (file.hasNextLine()){
				String data = file.nextLine();
				if (data.charAt(0)=='+'|| data.charAt(0)=='-') //Check if it is not Send command --> no comsumption
					continue;
				else {
					data=data.trim(); // Remove beginning and ending spaces
					String parts[] = data.split(":"); // Split the message from the command
					outgoing_traffic += parts[1].length(); // Get message size.
					//System.out.println(parts[1]);
				}
			}
			file.close();
			System.out.println(outgoing_traffic);
		}
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
