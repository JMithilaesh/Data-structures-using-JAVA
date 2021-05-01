public class CharQueue implements CharQueueable {
   public static final int CAPACITY = 1000;
   private char [] data;
   private int f = 0;
   private int sz = 0;
   
   public CharQueue(){
      data = (char []) new char[CAPACITY];   
   }
   
   public CharQueue(int capacity){
      data = (char []) new char[capacity];
   }
   
   
   
      
   public void enqueue(char element) throws IllegalStateException {
      if(sz == data.length){
         throw new IllegalStateException("Queue is full!");
      }else{
         int avail = (f + sz) % data.length;
         data[avail] = element;
         sz++;
      }
   }

    /**
     * Removes and returns the first element
     * @return element removed (or IllegalStateException if empty)
     */ 
    public char dequeue(){
      if (isEmpty()){
         throw new IllegalStateException("There are no elements in the queue!");
      }else{
         char answer = data[f];
         for(int i = 0; i < sz; i ++){
            data[i] = data[i+1];
         }
         sz--;
         return answer;
      }
    }

    /**
     * Returns, but does not remove, the first element
     * @return top element (or IllegalStateException if empty)
     */
    public char first (){
      if (isEmpty()){
         throw new IllegalStateException("There are no elements in the queue!");
      }else{
         return data[f];
      }
    }
    
    

    /**
     * Tests if the queue is empty
     * @return true if queue is empty; else false
     */
    public boolean isEmpty(){
      return (sz == 0);
    }

    /**
     * Returns the number of elements in the Queue
     * @return number of elements in the Queue
     */
    public int size(){
      return sz;
    } 
    
    public String toString() {
        if (isEmpty()) return "{}";
        else {
            
            String returnValue = "{" + data[0];
            if(sz > 1){
               for(int i = 1; i < sz; i++){
                  returnValue += ",";
                  returnValue += data[i];
                  
               }
            }
            
            returnValue += "}";
            return returnValue;
        }
    }
            



   
}