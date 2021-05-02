/*
This implementation class tests the ability of the BinarySearchTree class to add, search, remove, and catch if a key being removed is not there (In that case an IllegalStateException is thrown).
*/

public class TestBST {
    public static void main(String args[]) {
        BinarySearchTree BST1 = new BinarySearchTree();
        
        ///Test 1
        
        try{
            BST1.add(100);
            BST1.add(165);
            BST1.add(31);
            BST1.add(45);
            BST1.add(98);
            BST1.add(118);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        try{
           BST1.displayInorder();
           assertTrue("Test1: Search 118: ", BST1.search(118) == 118);
           assertTrue("Test1: Search 100: ", BST1.search(100) == 100);
           System.out.println("Minimum of the tree: " + BST1.findMin()); 
           System.out.println("Minimum of the tree: " + BST1.findMax());
           assertTrue("Test1: Remove 45: ", BST1.remove(45) == 45);
           BST1.displayInorder();
        }catch (IllegalStateException e){
         System.out.println(e);
        }
        
        ///Test 2
        BinarySearchTree BST2 = new BinarySearchTree();
        try{
            BST2.add(44);
            BST2.add(17);
            BST2.add(88);
            BST2.add(8);
            BST2.add(32);
            BST2.add(65);
            BST2.add(97);
            BST2.add(28);
            BST2.add(54);
            BST2.add(82);
            BST2.add(93);
            BST2.add(21);
            BST2.add(29);
            BST2.add(76);
            BST2.add(80);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        System.out.println("Size of tree: " + BST2.size());
        System.out.println("Inorder Traversal: "); 
        BST2.displayInorder();
        boolean pass = false;
        try{
          assertTrue("Test2: Search 80: ", BST2.search(80) == 80);
          assertTrue("Test2: Search 100: ",BST2.search(100)==100);
          System.out.print("Minimum of the tree: " + BST2.findMin() + "\n"); 
          System.out.print("Maximum of the tree: " + BST2.findMax() + "\n");
          assertTrue("Test2: remove 88: ", BST2.remove(88)==88);
        }catch(IllegalStateException e){
          pass = true;
          System.out.println(e);
        }
        
        try { 
            BST2.add(3);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        BST2.displayInorder();
        
        ///Test 3
        BinarySearchTree BST3 = new BinarySearchTree();
        try{
            BST3.add(10);
            BST3.add(20);
            BST3.add(30);
            BST3.add(40);
            BST3.add(50);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
       
        try{
         assertTrue("Test 3: remove 40: ", BST3.remove(40) == 40);
         assertTrue("Test 3: search 50: ", BST3.search(50) == 50);
         assertTrue("Test 3: remove 10: ", BST3.remove(10) == 10);
         BST3.add(60);
         BST3.add(70);
        } catch (IllegalArgumentException e) {
         System.out.println(e);
        }
        assertTrue( "Test 3: remove 20: ", BST3.remove(20) == 20);
        try{
        BST3.add(80);
        BST3.add(90);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        pass = false;
        try{
         BST3.displayInorder();
         assertTrue("Test 3: search 40: ", BST3.search(40) == 40);
         assertTrue( "Test 3: search 100: ", BST3.search(100) == 100);
        }catch(IllegalStateException e){
         pass = true;
         System.out.println(e);
        }
        pass = false;
        try{
          assertTrue( "Test 3: search 100: ", BST3.search(100) == 100);
        }catch(IllegalStateException e){
         pass = true;
         System.out.println(e);
        }
        
    }
    private static void assertTrue(String testName, boolean passed) {
        if (passed) System.out.println(testName + ": Passed!");
        else System.out.println(testName + "FAILED"); 
    }
}