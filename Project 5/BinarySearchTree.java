
public class BinarySearchTree {
    // Root of BST
    Node root;
    Node first;
    int size = 0;
    int rootVal;
 
    // Constructor
    BinarySearchTree(){
         root = null;
    }
 
    /* A recursive function to insert a new node in BST */
    public int add(int k){
         root = addNode(root, k);
         return root.key;
    }
    
    Node addNode(Node root, int key)
    {
       if(root == null) {
			root = new Node(key);
         size++;
			return root;
		}
		
		if(key < root.key) {
			root.left = addNode(root.left, key);
		} else {
			root.right = addNode(root.right, key);
		}
		return root;
    }
    
    // delete a node from the BST. Implement all the three cases for deletion. 
    public int remove(int k){
      Node r = deleteNode(root, k);
      if(r == null){
         return -1;
      }else{
         return k;
      }
      
    }
   
   //Function that deletes a node for all three cases.
   public Node deleteNode(Node root, int key) {
      if(root == null){ 
         return root;
      }
        if(key > root.key){
         root.right = deleteNode(root.right, key);
        }else if(key < root.key){
         root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null && root.right == null){
               root = null;
            }
            else if(root.left != null){
                root.key = predecessor(root);
                root.left = deleteNode(root.left, root.key);
            }
            else {
                root.key = successor(root);
                root.right = deleteNode(root.right, root.key);
            }
        }
        return root;   
   }
  
  //Finds the predecessor to the node deleted
  private int predecessor(Node root){
        root = root.left;
        while(root.right != null){
         root = root.right;
        }
        return root.key;
    }
    
    //Finds the successor to the node deleted
    private int successor(Node root){
        root = root.right;
        while(root.left != null){
         root = root.left;
        }
        return root.key;
    }      
        
    // search for a node with a key k. return the key if found; else throw an exeption
    public int search(int k){
      int counter = 0;
      boolean found = false;
      Node node = null;
      if(isEmpty()){
         throw new IllegalStateException("There are no values to search for!");
      }else{
         node = search(root, k);
      }
      if(node == null){
         throw new IllegalStateException("This value was not found:" + k);
      }else{
        return k; 
      }
    }
  
  //Binary tree search for the specified key.
  public Node search(Node root, int key){
   if(root == null || root.key == key){
      return root;
   }
   
   if(key < root.key){
      return search(root.left, key);
   } else {
      return search(root.right, key);
   }
}    // find and return the minimum key of the tree
    public int findMin(){
       Node current = root;
       while (current.left != null) {
            current = current.left;
        }
        return (current.key);
    }
    
    // find and return the maximum key of the tree
    public int findMax (){
      Node current = root;
       while (current.right != null) {
            current = current.right;
        }
        return (current.key);

        
    }
    // Tests if the list is empty. return true if Tree is empty; else false 
    public boolean isEmpty(){
        return size == 0;
    }
    //Returns the number of elements in the tree
    public int size(){
        return size;
    } 
    
    // print tree nodes in an inorder traversal 
    public void displayInorder(){
        inOrder(root);
        System.out.println("Traversal complete");
        
    }
    
    //In order traversal print of values.
    public void inOrder(Node root){
      if(root == null){
         return;
      }
      inOrder(root.left);
      System.out.print(root.key + " ");
      inOrder(root.right);  
      
    }
    
    private class Node {

        private Node left;
        private Node right;
        private int key;

        private Node(int data) {
            this.key = data;
            left = right = null;
        }
    }
 
}