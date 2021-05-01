public class CharStackLink implements CharStackable{
    private CharList list = new CharList();
    public CharStackLink() {}
    
    public void push(char element){
      list.addToHead(element);
    }

    /**
     * Removes and returns the top element
     * @return element removed (or null if empty)
     */ 
    public char pop (){
      return list.remove();
    } 

    /**
     * Returns, but does not remove, the top element
     * @return top element (or null if empty)
     */
    public char top (){
      return list.first();
    }

    /**
     * Tests if the stack is empty
     * @return true if stack is empty; else false
     */
    public boolean isEmpty(){
      return list.isEmpty();
    }

    /**
     * Returns the number of elements in the Stack
     * @return number of elements in the Stack
     */
    public int size(){
      return list.size();
    }
    
    public String toString(){
      return list.toString();
    }
     
}