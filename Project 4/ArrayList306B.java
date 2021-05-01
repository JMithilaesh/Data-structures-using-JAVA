/*This class implements the List306 and extends the ArrayList306 class to make it so that an array can be dynamically increased or minimized to fit the needs of the user.*/
public class ArrayList306B<E> extends ArrayList306<E> implements List306B<E> {

      public void increaseCapacity() throws IllegalStateException {
        // your code here
        if(isEmpty()){
            throw new IllegalStateException("There are no values in the array!");
        }
        E [] temp = (E[]) new Object[size*2];
        
        for(int k = 0; k < size; k++){
            temp[k] = data[k];
        }
        data = temp;
        
      }

      public void minimize() throws IllegalStateException {
        // your code here
        if(isEmpty()){
            throw new IllegalStateException("There are no values in the array!");
        }
        E [] temp = (E[]) new Object[size];
        for(int k = 0; k < size; k++){
            temp[k] = data[k];
        }
        data = temp;
        

        
      }

      public int capacity() throws IllegalStateException {
        // your code here
        if(isEmpty()){
            throw new IllegalStateException("There is nothing in the array!");
        }
        return data.length; // stub line 
      }
      
      public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        // your code here
        if(size == data.length){
               increaseCapacity();
        }

        for(int k = size - 1; k >= i; k--){
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }


 
}
