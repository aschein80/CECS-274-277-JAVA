package Project5;

import java.util.NoSuchElementException;

/**
 * This class is an interface that describes the methods used to analyze a list
 * @author Alex Schein
 * @since 4-26-2018
 * @version 3.0
 */

public interface ListIterator {
    
    /**
     * iterates past the next object in the list
     * @return the object analyzed by the iterator
     */
    public Object next();
    
    /**
     * checks for next object in the list
     * @return true or false depending on if object is = null
     */
    public boolean hasNext();
    
    /**
     * iterates through the previous object in the list
     * @return the object checked by iterator
     */
    public Object previous();
    
    /**
     * checks if there is a previous object
     * @return true or false depending on if object is = null
     */
    public boolean hasPrevious();
    
    /**
     * adds given data to current location
     * @param data - the new data
     */
    public void add(Object data);
    
    /**
     * removes the object at the current iterator position,
     * @return the object removed
     */
    public Object remove();
    
    /**
     * sets the current position to Object data passed in
     * @param data of the type Object
     */
    public void set(Object data);

}

