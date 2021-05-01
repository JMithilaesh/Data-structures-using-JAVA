import java.util.*;
public class CharList implements CharListable {

   private Node head;
   private Node tail;
   private int size;
   public CharList(){
      this.head = null;
      this.tail = null;
      this.size = 0;
   }
    
    public void addToHead(char data) {
      Node newNode = new Node(data);
      if(isEmpty()){
        tail = newNode;
      }else{
         head.previous = newNode;
      }
      newNode.next = head;
      head = newNode;
      size++;    
    }
    
        
    
    public void addToTail(char data) {
      Node newNode = new Node(data);
      if(isEmpty()){
         head = newNode;
      } else {
         tail.next = newNode;
      }
      newNode.previous = tail;
      tail = newNode;
      size++;
   
    }
    
    public char first(){
      if(isEmpty()){
         throw new IllegalStateException("There are no elements!");
      }else{
         return head.data;
      }
    }
    
    public char last(){
      if(isEmpty()){
         throw new IllegalStateException("There are no elements!");
      }else{
         return tail.data;
      }
    }
    
    

    public char remove() {
   
      if(isEmpty()){
         throw new IllegalStateException();
      }
      
      Node temp = head;
      if(head == tail){
         tail = null;
      }else{
         head.next.previous = null;
      }
      head = head.next;
      temp.next = null;
      size--;
      return temp.data;
         
    }
    
    public char removeLast() {
      if(isEmpty()){
         throw new IllegalStateException();
      }
      
      Node temp = tail;
      if(head == tail){
         head = null;
      }else{
         tail.previous.next = null;
      }
      tail = tail.previous;
      temp.previous = null;
      size--;
      return temp.data;
         

    }
    
    

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void sort() {
      long endTime = 0;
      long startTime = System.nanoTime();
      head = mergeSort(head);
      endTime = System.nanoTime() - startTime;
      System.out.println("Merge Sort - Time in ms: " + endTime);
      Node next = head;
      while(next.next != null){
         next = next.next;
         System.out.print(next.data);
      }
      tail = next;
     
            
    }
    
   public Node merge(Node first, Node second) { 
        // If first linked list is empty 
        if (first == null) { 
            return second; 
        } 
  
        // If second linked list is empty 
        if (second == null) { 
            return first; 
        } 
  
        // Pick the smaller value 
        if (first.data < second.data) { 
            first.next = merge(first.next, second); 
            first.next.previous = first; 
            first.previous = null; 
            return first; 
        } else { 
            second.next = merge(first, second.next); 
            second.next.previous = second; 
            second.previous = null; 
            return second; 
        } 
    }
      
    public Node mergeSort(Node node) { 
        if (node == null || node.next == null) { 
            return node; 
        } 
        Node second = split(node); 
  
        // Recur for left and right halves 
        node = mergeSort(node); 
        second = mergeSort(second); 
        // Merge the two sorted halves 
        return merge(node, second); 
    }   
    
    public Node split(Node head) { 
        Node fast = head, slow = head; 
        while (fast.next != null && fast.next.next != null) { 
            fast = fast.next.next; 
            slow = slow.next; 
        } 
        Node temp = slow.next; 
        slow.next = null; 
        return temp; 
    } 

    public Node partition(Node l, Node h){
      char x = h.data;
      
      Node i = l.previous;
      
      for(Node j = l; j!=h; j=j.next){
         if(j.data <= x){
            i = (i==null) ? l :i.next;
            char temp = i.data;
            i.data = j.data;
            j.data = temp;
         }
      }
      i = (i==null) ? l : i.next;
      char temp = i.data;
      i.data = h.data;
      h.data = temp;
      return i;
    }
    
    public void quickSort(Node l, Node h){
      if(h!=null && l!=h && l!=h.next){
         Node temp = partition(l, h);
         quickSort(l, temp.previous);
         quickSort(temp.next, h);
      }
    }
    
    public void sortQuick(){
      long endTime = 0;
      long startTime = System.nanoTime();
      quickSort(head, tail);
      endTime = System.nanoTime() - startTime;
      System.out.println("Quick Sort - Time in ms: " + endTime);
    }
    


    public String toString() {
        if (isEmpty()) return "{}";
        else {
            Node currentNode = head;
            String returnValue = "{" + currentNode.data;
            while (currentNode.next != null) { 
                currentNode = currentNode.next;
                returnValue += "," + currentNode.data;
            }
            
            returnValue += "}";
            return returnValue;
        }
            
        
     
    }
    
     public String toStringReverse() {
        if (isEmpty()) return "{}";
        else {
            Node currentNode = tail;
            String returnValue = "{" + currentNode.data;
            while (currentNode.previous != null) { 
                currentNode = currentNode.previous;
                returnValue += "," + currentNode.data;
            }
            
            returnValue += "}";
            return returnValue;
        }
            
        
     
    }


    /** Node class definition (inner class) **/

   public class Node{
      private char data;
      private Node previous;
      private Node next;
      
      public Node(char data){
         this.data = data;
      }
     
   }
}