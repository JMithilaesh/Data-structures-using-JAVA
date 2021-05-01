public class CharStack implements CharStackable{
    public static final int CAPACITY=1000;
    private char [] data;
    private int t = -1;
    public CharStack() {
      data = (char []) new char[CAPACITY];  
    }
    
    public CharStack(int capacity) {
      data = (char []) new char[capacity];  
    }
    
    public void push(char element) throws IllegalStateException{
      if(size() == data.length){
         throw new IllegalStateException("Stack is full");
      }else{
         data[++t] = element;
      }
      
    }

    /**
     * Removes and returns the top element
     * @return element removed (or null if empty)
     */ 
    public char pop (){
      if(isEmpty()){
         throw new IllegalStateException("Nothing in the stack!");
      }else{
         return data[t--];

      }
    } 

    /**
     * Returns, but does not remove, the top element
     * @return top element (or null if empty)
     */
    public char top (){
      if (isEmpty()){
         throw new IllegalStateException("No elements in stack");
      }else{
         return data[t];
         
      }
    }

    /**
     * Tests if the stack is empty
     * @return true if stack is empty; else false
     */
    public boolean isEmpty(){
      return (t == -1);
    }

    /**
     * Returns the number of elements in the Stack
     * @return number of elements in the Stack
     */
    public int size(){
      return (t+1);
    } 
    
     public String toString() {
        if (isEmpty()) return "{}";
        else {
            char array [] = new char[size() + 1];
            int counter = size();
            String returnValue = "{";
            for(int i = 0; i < size(); i++){
               array[counter] = data[i];
               counter--;
            }
            for(int i = 1; i < array.length; i++){
               if(i == 1){
                  returnValue += array[i];
               }else{
                  returnValue+= "," + array[i];
               }
            }
            returnValue += "}";
            return returnValue;
            
      }
          
            
            
           
        }
        
    }

