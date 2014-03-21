/*

An implementation of LinkedList with the following functionality

- InsertAtTheLast -----> Theta(n)
- deleteElement(element) ----> Theta(n)
- listAllElements-----> Theta(n)
- search(element) -----> Theta(n)
- reverse ------> Theta(n)

*/

class LinkedListDS {
	
	public String data = null ;
	public LinkedListDS next = null;
	
	public LinkedListDS head = null;
	
	public boolean insertAtTheLast(String element)	{
		if(element == null)
			return false;
		
		if(head == null) { // means its the first element
			head = this;
			head.data = element;
			head.next = null;
			return true;
		}
		
		LinkedListDS last = head;
		while(true) {
			if(last.next == null)
				break;
			last = last.next;
		} 
		
		LinkedListDS e = new LinkedListDS();
		e.data = element;
		last.next = e;
		return true;
	}
	
	
	
	public boolean deleteElement(String element) {
		if(element == null)
			return false;
		else if(this.head == null)
			return false;
		else
		{
			LinkedListDS currentElement = this.head;
			LinkedListDS prevElement = currentElement;
			while(currentElement != null)
			{
				if(head.data.equals(element))
				{
					head = currentElement.next;
					currentElement = head;
				}
				else if(currentElement.data.equals(element))
				{
					prevElement.next = currentElement.next;
					currentElement = null;
				}
				else
				{
					prevElement = currentElement;
					currentElement = prevElement.next;
				}
			}
			return true;
		}
	}
	
	public boolean listAllElements() {
		
		if(this.head == null)
			return false;
		
		LinkedListDS currentElement = this.head;

		while(currentElement != null) {
			System.out.println(currentElement.data);
			currentElement = currentElement.next;
		}

		return true;		
	}
	
	public LinkedListDS search(String element){
		
		LinkedListDS currentElement = head;

		while(currentElement != null) {
			if(currentElement.data.equals(element))
				return currentElement;
			currentElement = currentElement.next;
		}

		return null;
	}
    
    public LinkedListDS reverse() {
        
        LinkedListDS prev = null;
        LinkedListDS current = head;
        LinkedListDS next = current.next;
        
        if(head == null)
            return null;
        if(next == null)
            return head;
        
        while(current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if(current != null)
                next = current.next;
        }
        
        head = prev;
        return head;
        
    }
	
	@Override 
	public String toString(){
		return this.data;
	}
}


public class LinkedListVichu{
	
	
	public static void main(String[] args) {
		
		LinkedListDS element = new LinkedListDS();
		element.insertAtTheLast("1");
		element.insertAtTheLast("2");
		element.insertAtTheLast("3");
		System.out.println("Printing all elements:");
		element.listAllElements();
		System.out.println("\nPrinting all elements after deleting 2:");		
		element.deleteElement("2");
		element.listAllElements();
		
		System.out.println("\nPrinting all elements after deleting 3:");		
		element.deleteElement("3");
		element.listAllElements();
		System.out.println("\nPrinting all elements after deleting 1:");		
		element.deleteElement("1");
		element.listAllElements();

		System.out.println("\nPrinting all elements adding one and two:");				
		element.insertAtTheLast("One");
		element.insertAtTheLast("Two");
		element.listAllElements();		
		
		System.out.println("\nPrinting all elements after deleting one now:");
		element.deleteElement("One");
		element.listAllElements();		
		
		System.out.println("Search for Two : "+ element.search("Two"));
		System.out.println("Search for One : "+ element.search("One"));
        
        System.out.println("Delete TWO:");
        element.deleteElement("Two");
        
        System.out.println("List all elements: ");
        element.listAllElements();
        
        System.out.println("No elements\n-----------------\nAdding 1, 2, 3 for reversal");
        element.insertAtTheLast("1");
		element.insertAtTheLast("2");
		element.insertAtTheLast("3");
		System.out.println("Printing all elements:");
		element.listAllElements();
        
        System.out.println("Reversal of linkedlist with just head pointer...");
        element.reverse();
        System.out.println("Print reverse elements now");
        element.listAllElements();
        
        
	}
}