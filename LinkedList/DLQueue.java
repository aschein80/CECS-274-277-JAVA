package Project5;

import java.util.NoSuchElementException;

/**
 * this class models a queue that uses a double-linked list 
 * @author Alex Schein
 * @since 4-26-2018
 * @version 3.2 *
 */
public class DLQueue {  
	
    private Node first;			//Node First
    private Node last;			//Node Last
    
    
    public DLQueue() {
        
    	first = null;			//iniitialzing node First to null
   
    	last = null;			//initializng node Last to null
    }
    
    /**
     * adds element to the end of the list
     * tests the nodes to see if they're null
     * @param data - Object Data stored in the list at the top
     */
    public void add(Object data) {

        if(first == null) {			//TESTING IF FIRST NODE = NULL
            addFirst(data);				//data added to the head of the list using addFirst method
        }
        else {
            addLast(data);		//else data added to the end
            
        }
      }
    
    
    /**
     * removes the head of the list
     * @return data removed from the queue
     */
    public Object remove() {
        Object temp = removeFirst();
        return temp;						//returning the data removed from the queue called temp
    }
    
    /**
     * returns the data in the head of the list ("peek at the head")
     * @return data in the place at position head 
     */
    public Object peek() {
    	
        return first.data;			//returning the data in the place of the head
        
    }
    
    /**
     * adds element to the top
     * @param data - of the type object, stored at top of the list
     */
    public void addFirst(Object data) {
    	
        Node newNode=new Node();
        
        newNode.data=data; 
        
        if(first!=null) {
            first.previous = newNode;
            newNode.next=first;
        }
        
        first=newNode;
        if(last == null) {
            last = first;
            last.previous = newNode;
        }
    }

    /**
     * adds element to the end of the list
     * @param data - of the type object, stored at top of the list
     */
    public void addLast(Object data) {
        Node newNode = new Node();
        newNode.data = data;
        
        if(last != null) {
            newNode.previous=last;
            last.next = newNode;
        }
        last = newNode;
        if(first == null) {
            first = last;
            first.next = newNode;
        }
    }
    
    /**
     * removes data at the top
     * @return data at location of removed node
     */
    public Object removeFirst() {
    	
        if(first==null) { //if the list is empty
            throw new NoSuchElementException();
        }
        Object temp=first.data;
        
        first=first.next;		//setting first = location
        
        return temp;			//returning temp
    }

    /**
     * node is an inner class, which means access to it is restricted to
     *members of its outer class, i.e. LinkedList
     */
    
    class Node{
       
    	//these variables do not need setters or getters because they are
        //public, and thus can be accessed/modified by any member of the 
        //outer class, i.e. LinkedList
    	
    	
        public Object data;
        public Node next;
        public Node previous;

    }
    
    /**
     * add and print names of the list in the queue
     */
    public static void main(String[] args) {
        
        DLQueue names = new DLQueue();			//new queue double linked list
        
        names.add("Captain America");				//adding names to the list
        names.add("Dr. Strange");


        names.add("Hawkeye");
        names.add("Spiderman");

        names.add("Ant man");
        
        
        System.out.println(names.peek());
        
        System.out.println(names.remove());
    
        System.out.println(names.peek());
        
        System.out.println(names.remove());
        
        System.out.println(names.remove());

        System.out.println(names.remove());
        
        System.out.println(names.peek());
        

        
    }
    
}



