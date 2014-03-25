/*

Implement Min Stack.
Min Stack is a stack where pushing, poping and min element action takes Theta(1).

*/
public class MinStack {
    
    Node top = null;
    
    public void push(int data) {
        
        Node element = new Node();
        element.data = data;
        element.next = top;
        
        if(top == null)
            element.minData = data;
        else {
            if(top.data > data)
                element.minData = data;
            else
                element.minData = top.minData;
        }            
        
        top = element;
            
    }
    
    public Node pop() {
        Node popObject = null;
        if(top != null) {
            popObject = top;
            top = top.next;    
        }            
        
        return popObject;
    }
    
    public int minElement() {
        if(top != null)
            return top.minData;
        return Integer.MIN_VALUE;
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        
        minStack.push(2);
        minStack.push(1);
        minStack.push(4);
        minStack.push(3);
        System.out.println("Pop element :"+ minStack.pop().data);
        System.out.println("Min element :"+ minStack.minElement());
    }
     
}

class Node {
    int data;
    Node next;
    int minData;
}