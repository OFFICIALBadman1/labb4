package labb4;

import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;



public class Fil {

	
	// mål skriva ut alla kvinnor före alla män
	/*
	 * Persondata betyder att varje rad
innehåller först personnummer (den 12-siffriga varianten), ett blanktecken och
så namn. Om filen innehåller de 6 raderna
20030816-5539 Johan Herman af Ugglas Man 1
19860115-1783 Anna Kajsa Karlsson Kvinna 1
20011024-9844 Elisabet Ida Andersson Kvinna 2
19971224-1836 Hans Peter Bildt Man 2
19690814-2190 Tor Gustav Ödman Man 3
19960205-2442 Solveig Lotta Thelander Kvinna 3
	 */
	public Fil() {
		Stack<String> män = new Stack<>();  
		
		
	}
	
	

	public static void main(String[] args)  {
		Stack<String> män = new Stack<>();  
		// TODO Auto-generated method stub
		
		// /D0035E/src/labb4/persondata-1.txt
		
		try { 
			Scanner sc = new Scanner(System.in); //scanner användar jag så användaren kan skriva in filsökvägen i terminalen
			System.out.println("Skriv in filsökvägen:"); 
			
			String filInput = sc.nextLine(); //returnerar endast det som användaren skriver in till variabeln filInput
			sc.close(); //stänger scannern 
			
			FileReader filLäs = new FileReader(filInput); //Använder Filereader för att läsa filen skapar ett objekt av det, som tar in filsökvägen som användaren skriver in, sparrar i referensen läs. 
			BufferedReader läsaren = new BufferedReader(filLäs); //Använder bufferreader. Läser in filen. 
			
			
			läsaren.read(); //läser en rad. Om en rad innehåller
			
			
			String line; // denna ska hålla varje rad med text som vi läsar. 
			
		
			
			while ((line = läsaren.readLine()) != null){ // Ska läsa en line av text från input filen, och placera den line av text till line variabeln, när någgon rad inte finns komemr den att avsluta loopen.
				
				String [] splittar = line.split(" "); //splittar mellan dom olika delarna. 0030816-5539 Johan Herman af Ugglas. Personnumret blir då index[0] i arraayen
				
				String personnumret = splittar[0]; // sparar personnuimret, som är det första indexet innan man splittar. 
				char nästSistaindexPerson = personnumret.charAt(11); 
				

				// System.out.println(nästSistaindexPerson); 
				// om näst sista siffran i personnumret är jämnt så är det en kvinna. Detta blir då index 10 
				
				if (nästSistaindexPerson%2 == 0) {
					System.out.println(line); // skriver ut alla kvinnor
				} else {
					män.push(line);  //PUSHAR DEN FÖRSTA MANNEN. LIFO. 
					
				}
				
				// måste nu reversa. 
				
				
				
				
			
				
				
				
				//if ((splittar[0].charAt(10)) % 2 == 0 ) {
				//	System.out.println(line); 
				// }
				
			
				
				// om näst sista siffran
				//LAST IN first out. Den som ska vara högst upp är den första kvinnan. Första mannen högst upp för männen. 
				
				// jag vill sedan spara allting i en lista
				
				// om det är en kvinna på raden så ska den göra följande.Dvs on det är ett jämn siffra på det
				
				
			}
			System.out.println("\n"); //mellanrum mellan kvinnor och män. 
			
			while(!män.empty()) { //om stacken inte är tom, 
				System.out.println(män.pop()); //printa ut det som togs bort. 
			}
			
			läsaren.close(); //stänga Bufferreader
			
			
			
		} catch (IOException e) {
			System.out.println("Error filen finns inte"); 
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
