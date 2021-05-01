public interface List306B<E> {

    /* 
    This method copies the array into a new array with
    a size that is greater than its current size, and 
    replaces the original array with the new one. You 
    may choose to implmement either a constant or 
    doubling algorithm. If the array is uncreated, then 
    throws IllegalStateException.
    */
    void increaseCapacity() throws IllegalStateException; 

    /* 
    This method copies the array into a new array with
    a size that exactly matches the number of elements, 
    and replaces the original array with the new one.
    If array is empty, or hasn't been created yet, then 
    throws IllegalStateException.
    */
    void minimize() throws IllegalStateException; 

    /* 
    This method returns the length of the array (not how
    many elements are in it). If the array has not been 
    created, then throws IllegalStateException. 
    */
    int capacity() throws IllegalStateException;

}
