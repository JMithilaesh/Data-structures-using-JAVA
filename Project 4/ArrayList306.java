/*This class implements the List306 and makes it simple to manipulate an array list until the capacity is met*/
public class ArrayList306<E> implements List306<E> {

    public static final int CAPACITY = 16;
    protected E[] data;
    protected int size = 0;

    public ArrayList306() { this(CAPACITY); }

    public ArrayList306(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        // your code here
        return size; // stub code
    }

    public boolean isEmpty() {
        // your code here
        return size == 0; // stub code
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i]; // stub code
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        // your code here
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp; // stub code
    }

    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        // your code here
        checkIndex(i, size);
        if(size == data.length){
         throw new IllegalStateException("Array is full");
        }
        
        
        for(int k = size - 1; k >= i; k--){
            data[k + 1] = data[k];
        }
        
        data[i] = e;
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new IllegalStateException("The array is empty!");
        }
        checkIndex(i, size);
        E temp = data[i];
        for(int k = i; k < size - 1; k++){
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
        return temp; // stub code
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if(n == 0){
            if(i < 0){
               throw new IndexOutOfBoundsException("Illegal index: " + i);
            }
        }else{
           if(i < 0 || i >= n){
               throw new IndexOutOfBoundsException("Illegal index: " + i);
           }
        }
    }
    
}