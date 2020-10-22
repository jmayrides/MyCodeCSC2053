/**
 * Interface for a class that implements a collection of T.
 * A collection allows addition, removal(not in this version), 
 * and access of elements.
 * 
 * Null elements are not allowed. Duplicate elements are allowed.
 * @author Your name
 *
 * @param <T>
 */
public interface CollectionInterface<T> {
	
	/**
	 * Attempts to add element to this collection.
	 * @param element
	 * @return Returns true if successful, false otherwise. 
	 * Return false if element is null, otherwise true.
	 */
    boolean add(T element); 

    /**
     * Returns an element e from this collection such that e.equals(target).
     * If no such e exists, returns null.
     * @param target
     * @return 
     */
    T get(T target);
    
    /**
     * Removes element if found
     * @param element
     * @return true if found and removed, otherwise false
     */
    boolean remove(T element);
    
   
 

    /**
     * Returns true if this collection contains an element e such that
     * e.equals(target); otherwise returns false.
     * @param target
     * @return
     */
    boolean contains(T target);

    /**
     * Returns true if this collection is full; otherwise, returns false.
     * @return 
     */
    boolean isFull();

    /**
     * Returns true if this collection is empty; otherwise, returns false.
     * @return 
     */
    boolean isEmpty();
  
    /**
     * Returns the number of elements in this collection.
     * @return
     */
    int size();
}
