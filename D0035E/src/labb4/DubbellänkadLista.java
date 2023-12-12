package labb4;

import java.util.NoSuchElementException;

// Isak Jonson Zachari. 1B

public class DubbellänkadLista<E> {
	
	public DubbellänkadLista() { /*konstruktor: "Em nnyskapad lista är tom. Internt skapar konstruktorn en nodkedja med endast två 
		noder, headernoderna, som refererar till varandra: 
		// TODO Auto-generated constructor stub
		*/ 
		start = new Nod(null); // sätter referensen i headernoden till null
		slut =  new Nod(null); // sätter rwferensen i slutet till null. 
		start.nästa = slut; //när det inte finns andra noder så pekar först första noden på sista noden
		slut.föregående = start; //denna pekar på förgående nod dvs start noden. 
		
		
	}

	protected class Nod { //internt lagras elementen i en nodkedja, noderna ska vara objekt inre klass "nod". Tre fält finns. i single länkad lista finns 2 fält. 
		Nod nästa; // Pointer till nästa nod/referens. Första fältet. 
		Nod föregående; //förgående nod. Skillnaden mot enkel länkad lista. Denna har även pointer till förgående nod, eller referens. Andra fältet
		E element; // Det element som noden innehåller. Elementet på varje nod kan vara av vilken typ som helst. instansvariabel
		public Object start;

		Nod(E element) {// Detta är konstrkutorn till klassen Nod. Tar emot element av typen E, vilken typ som helst. 
			this.element = element; //Konstruktorn placerar fältet för elementet till det element som angivits.  till instansvariabeln element och inte parametern
		}
	}

	protected Nod start, slut; //Fältet start refererar till inledande (start) och avslutande headernoden (slut) i listan. 
	protected int storlek = 0; //Ej interna nodkedjans längd (pga sista och första noden). Den faksitks listans storlek detta. storlek referar till listans längd. fördelen med linkedlist att denna är dynamisk, fördelaktig då maj ej vet storleken på listor, och att storleken ändras ofta. 

	public String toString() { //metoden representerar listan med strängar. Börjar med "[
		String sträng = "[ "; //listan börjar med "["
		Nod nod = start.nästa; //går till noden efter den första headernoden
		while (nod.nästa != null) { // så länge nästa nod inte är null så kommer den loopa.
			sträng += nod.element + " "; // lägger till den nod som innehåller ett element till strängen eller listan. 
			nod = nod.nästa; // går till näst nod i listan. 
		}
		return sträng + "]"; // denna returnerar strängen. Hela listan. 
	}

	public static void main(String[] args) {
		// Inkludera testkod här som skapar en lista och använder den
	}
	
	
	
	
	public void läggTillFörst(E element) { //ska lägga till element först i listan
		Nod nyNod = new Nod(element); //Skapar en ny nod som ska innehålla det element som ska läggas till i listan. skapar ett objekt av klassen Nod, refererar till den. Elementen lagras internt i en nodkedja. 
		nyNod.nästa = start.nästa; // den nya nodens "nästa" pekare/referens pekar från den nurvarande noden till nästa noden. Den nya noden blir alltså den nya nästa noden. dvs noden efter.
		start.nästa.föregående = nyNod; //den nod som just nu är den första i listan kommer att hänvisa till den förgående noden som sin nya nod. 
  
		// Den tidigare pekarens nästa nod uppdateras för att peka på nästa nod. pekare, det element som noden ska innehålla, har pointers för förgående nod och till nästa nod. Dvs den
		// Detta gör det möjligt för nästa nod att komma åt förgående nod. Dvs förgående nod. Vilket är skillnaden mot sinele linked list. 
		start.nästa = nyNod; // Start noden kommer att hänvisa den nya noden som sin nästa nod.Dvs header kommer att hänvisa till den nya noden som sin nästa nod.  
		nyNod.föregående = start; // den nya nooden kommer att peka på sin fögrående nod som startnoden, dvs header. 
		storlek = storlek + 1; //storlek ökar med 1 när ett element läggs till. 
	
		
		
		// storlek ökas med 1
		
	}
	
	public void läggTillSist(E element) { //lägga till element sist. Gör tvärtom som läggTillFörst
		Nod nyNod = new Nod(element); 
		nyNod.föregående = slut.föregående; 
		slut.föregående.nästa = nyNod; 
		slut.föregående = nyNod; 
		nyNod.nästa = slut;
		
		storlek = storlek + 1; //storlek ökar med 1 
		
		
		
	}
	
	// Kastar NoSuchElementException om listan är tom 
	public E taBortFörsta() //tar bort första noden i nodkedjan, och returnera det första elementet
		throws NoSuchElementException {
			if (storlek == 0) {
				throw new NoSuchElementException(); 
				}
			// sparar först det element jag vill ta bort, dvs det i första noden i nodkedjan. 
			E elementet = start.nästa.element; //skapar en variabel av typen vad som helst för elementet som ska tas bort, dvs den första variabeln i nodkedjan. Element är det första elementet som finns i den första noden i nodkedjan (dvs denf aktiska listna). 
			
			// tar sedan bort den första noden (Start.nästa)
			start.nästa = start.nästa.nästa; // den första noden blir den andra noden i listan eller tvärtom 
			start.nästa.föregående = start; //den andra noden som nu blev den första, hänvisar nu till startnoden (den med null element) "header" 
			storlek = storlek - 1; //storleken på listan minskas med 1 element när man tar bort element 
		
			return elementet; //returnerar det elementet som togs bort
		
		
		
		
	}
	
	public E taBortSista() throws NoSuchElementException { //tar bort sista elementet, gör tvärtom jämfört med att taBortFörsta elementet
		if (storlek == 0) {
			throw new NoSuchElementException(); 
			}
		
		E elementet = slut.föregående.element; //Den sista noden i listan som innehåller ett element, dvs den som ska tas bort, det elementet blir nu till variabeln elementet. 
		slut.föregående = slut.föregående.föregående; // den näst sista noden blir nu den sista noden som innehåller ett element
		slut.föregående.nästa = slut; //näst sista elementet som nu blev det sista som ej är "header" har nu en pointer tillbaka till slut, dvs header. 
		
		
		storlek = storlek - 1; //storleken på listan minskas med 1 element när man tar bort element 
		
		return elementet;  // retuenerar sista elementet
		
	}
	
	public int längd() { //som ger antal element i listan vid anropstillfället 
					
		return storlek; //
		
		
	}
	

	

}

