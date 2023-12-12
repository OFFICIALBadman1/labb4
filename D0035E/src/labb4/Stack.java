package labb4;


import java.util.EmptyStackException;


public class Stack<E> {
	private DubbellänkadLista<E> listan; //internt (private) lagra och manipulera innnehåll med hjälp av listan. 
	
	
	public Stack() { //intert lagra och mainpulera innehåll med hjälp av dobbellänkad lista ur uppgift 1. 
		// TODO Auto-generated constructor stub
		listan = new DubbellänkadLista<>(); //skapar ett objekt av till konstruktu
		
	}
	
	/*
	 * public E pop()
Removes the object at the top of this stack and returns that object as the value of this function.
Returns:
The object at the top of this stack (the last item of the Vector object).
Throws:
EmptyStackException - if this stack is empty.
	 */
	public E pop() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException(); 
			
		}
		return listan.taBortFörsta(); 

			}
	/*
	 * public boolean empty()
Tests if this stack is empty.
Returns:
true if and only if this stack contains no items; false otherwise.

	 */
	public boolean empty() { //retuenrer true om listan är tom.
		return listan.equals(null); 
		
	}
	
	/* public E peek()
	Looks at the object at the top of this stack without removing it from the stack.
	Returns:
	the object at the top of this stack (the last item of the Vector object).
	Throws:
	EmptyStackException - if this stack is empty.
*/
	public E peek() {
		return null; 
	}
	/* Pushes an item onto the top of this stack. This has exactly the same effect as:
	 addElement(item)
	Parameters:
	item - the item to be pushed onto this stack.
	Returns:
	the item argument
	*/ 
	
	public E push(E element) {
		listan.läggTillSist(element); 
		return element; 
		
	}
	
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
