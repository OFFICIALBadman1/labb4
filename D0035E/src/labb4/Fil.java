package labb4;

import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Fil {

	public Fil() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			File filen = new File("persondata-1.txt"); 
			Scanner läsa = new Scanner(filen); 
			while (läsa.hasNextLine()) {
				String texten = läsa.nextLine(); 
				System.out.println(texten); 
			}
			
			läsa.close(); 
			
			
				
		} catch (IOException e) {
			System.out.println("Error filen finns inte"); 
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
