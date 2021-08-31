package Project5;

import java.util.NoSuchElementException;

/**]
 * Instantiates a linked list object using node storing null object data and references to the next and previous nodes
 * @author Alexandre Schein
 * @version 3.0.1
 * @since 4-26-2018
 */
public class DLinkedList {

	private Node first;
    private Node last;
    
    public DLinkedList() {
        first = null;				//initializing
        last = null;
    }
    
    /**
     * adds element to the top 
     * @param data - the object stored at the top
     */
    public void addFirst(Object data) {
        Node newNode=new Node();
        newNode.data=data; 
        
        if(first!=null) {
            first.previous = newNode;	// previous reference of first node set = to new node
            newNode.next=first;			
        }
        
        first=newNode;				//setting First = newNode 
        
        if(last == null) {
            last = first;		//setting 2nd node = previous node
            last.previous = newNode;
        }
    }

    /**
     * adds an element to the end of list
     * @param data - object stored at the top
     */
    public void addLast(Object data) {
    	
        Node newNode = new Node();			//setting new node
        newNode.data = data;				//initializing the data of the node
        		
        if(last != null) {					//if last DNE null
            newNode.previous=last;			//setting the previous node = to new node
            last.next = newNode;			//node after last node is new node
        }
        last = newNode;						//setting last = new node
        
        if(first == null) {					//
            first = last;
            first.next = newNode;
        }
    }
    
    /**
     * retrieves item stored at beginning
     * @return the data at the beginning
     */
    public Object getFirst() {
    	
        if(first==null) {throw new NoSuchElementException();}
        return first.data; 				//returning
        
        //this is the syntax for getting the
        //"data" attribute of the object called "first"
        //we can do this because "data" is public and thus does not need a 
        //getter method
    }
    
    /**
     * gets the data of the element and returns it
     * @return the data stored at end 
     */
    public Object getLast() {
        if(last==null) {throw new NoSuchElementException();}		//testing if last is null
        return last.data;						//returning
    }
    
    /**
     * removes the first node of the list
     * @return returns data of removed node
     */
    public Object removeFirst() {
        if(first==null) { 							//if the list is empty
            throw new NoSuchElementException();		//throw exception
        }
        Object temp=first.data;					//
        
        first=first.next;						//
        first.previous = null;
        
        return temp;						//returning the temp
    }
    
    public Object removeLast() {
        if(last==null) {throw new NoSuchElementException();}
        Object temp = last.data;
        last = last.previous;
        last.next = null;
        return temp;			//returning temp
    }
    
    
    public ListIterator listIterator() {
    	
        //we return ListIterator because it is public interface that can be used outside of the LinkedList class versus
        //LinkedListIterator only exists inside LinkedList
    	
    	
        return new LinkedListIterator();
    }
    
    public boolean contains(Object data) {
        boolean found = false;
        ListIterator iter = listIterator();
        Object something;
        
        if(first == null) {
            return found;
        }
        
        while(iter.hasNext()) {
            something = iter.next();
            if(something == data) {
                found = true;
                return found;
            }
        }
        
        return found;
    }
    
    /**
     *LinkedListIterator implements ListIterator 
     */
    class LinkedListIterator implements ListIterator {
        private Node position = null;
        private Node previous = null;
        private Node next = null;
        boolean isAfterNext;
        boolean isAfterPrevious;
        
        public LinkedListIterator() {
            
        }

        @Override
        public Object next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = position;    //updating previous to be at the current position
            if(position == null) { //iterator is at beginning of the list
                position = first;
            }
            else {
                position = position.next;
            }
            isAfterNext = true;
            return position.data;
        }
        
        @Override
        public Object previous() {
            if(!hasPrevious()) {
                throw new NoSuchElementException();
            }
            next = position;    //updating next to be at the current position
            if(position == null) { //iterator is at beginning/end of the list
                position = first;
            }
            else {
                position = position.previous;
            }
            isAfterPrevious = true;
            return previous.next.data;
        }


        @Override
        public boolean hasNext() {
            if(position==null) //if the iterator is at the beginning of the list
            {return first!=null;}
            else {
                return position.next!=null;
            }
        }

        @Override
        public boolean hasPrevious() {
            if(position==null) {return last!=null;}
            else {
                return position.previous!=null;
                }
        }    
        
        @Override
        public void add(Object data) {
            if(!isAfterNext && !isAfterPrevious) {
                throw new IllegalStateException();
            }
            if(position == first) {			//if the position is first
                addFirst(data);				
            }
            else if(position == last) {			//else if position = last
                addLast(data);
            }
            else {
            	
                Node newNode = new Node();
                newNode.data = data;
                
                newNode.next = position.next;
                newNode.previous = position.previous;
                
                position.next = newNode;
                position.previous = newNode.previous;
                position = newNode;
            }
        }

        @Override
        public Object remove() {
            if(!isAfterNext && !isAfterPrevious) {
                throw new IllegalStateException();
            }
            
            Object temp;
            
            if(position == first) {
                temp = removeFirst();
            }
            else if(position == last){
                temp = removeLast();
            }
            else {
                temp = position.data;		
                previous.next = position.next;    
            }
            position = previous;			//setting position to the position of previous node
            isAfterNext = false;
            isAfterPrevious = false;		
            return temp;					//returning the temp
        }

        @Override
        public void set(Object data) {
            if(position==null) {
                throw new NoSuchElementException();
            }
            position.data = data;
        }
        
    }

    /**
     *this class creates node objects that store data reference to the next and previous node
     */
    class Node{
    	
        //these variables do not need setters or getters because they are
        //public, and thus can be accessed/modified by any member of the 
        //outer class, i.e. LinkedList
    	
        public Object data;
        public Node next;
        public Node previous;

    }

}

