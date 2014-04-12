class Node {
    Node next = null;
    int data;
}

public class LinkedListLoop {
    
    Node head = null;
    
    public boolean findLoops() {
        
        if(head != null) {
            Node slowPointer = head;
            Node fastPointer = head;
            
            while(fastPointer != null) {
                slowPointer = slowPointer.next;
                
                if(fastPointer.next == null) 
                    return false;
                
                fastPointer = fastPointer.next.next;
                
                if(slowPointer.data == fastPointer.data) 
                    return true;
            }
        }
        return false;
    }
    
    public Node addElement(int data) {
        
        if(head == null) {
            head = new Node();
            head.data = data;
            return head;
        }
        else {
            Node last = head;
            while(last.next != null) {
                if(last.next.next != null) 
                    last = last.next.next;
                else
                    last = last.next;
            }
            Node element = new Node();
            element.data = data;
            last.next = element;
            return element;
        }
            
    }
    
    public void addALoop(Node elementVertex, Node last) {
        last.next = elementVertex;
    }
    
    public void display() {
     
        System.out.println("Elements are :");
        if(head != null) {
            Node element = head;
            while(element != null) {
                System.out.print(element.data+" ");
                element = element.next;
            }
        }    
    }
    
    public static void main(String[] args) {
        LinkedListLoop myList = new LinkedListLoop();
        
        myList.addElement(1);
        Node element = myList.addElement(2);
        myList.addElement(3);
        myList.addElement(4);
        Node last = myList.addElement(5);
        myList.display();
        System.out.println("\nLoop ? "+myList.findLoops()); 
        System.out.println("Adding a loop now...");       
        myList.addALoop(element, last);
        System.out.println("Loop ? "+myList.findLoops());
        
        
    }
    
    
}

