public class CharQueueList implements CharQueueable {
    private CharList list = new CharList();
    public CharQueueList() {}
    
 public void enqueue(char element){
   list.addToTail(element);
 }

    /**
     * Removes and returns the first element
     * @return element removed (or IllegalStateException if empty)
     */ 
    public char dequeue(){
      return list.remove();
    }

    /**
     * Returns, but does not remove, the first element
     * @return top element (or IllegalStateException if empty)
     */
    public char first (){
      return list.first();
    }

    /**
     * Tests if the queue is empty
     * @return true if queue is empty; else false
     */
    public boolean isEmpty(){
      return list.isEmpty();
    }

    /**
     * Returns the number of elements in the Queue
     * @return number of elements in the Queue
     */
    public int size(){
      return list.size();
    }
    
    public String toString(){
      return list.toString();
    }

}