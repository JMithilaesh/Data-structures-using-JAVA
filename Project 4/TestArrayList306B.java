
public class TestArrayList306B {

    public static void main(String[] args) {

        try {
            ArrayList306B<Integer> myList;
            myList = new ArrayList306B<Integer>();

            try {
                myList.add(0,0);
                myList.minimize();
                assertTrue("Test4.1", myList.size() == myList.capacity());
            } catch (Exception e) {
                assertTrue("Test4.1 -- Unexpected Exception: " + e.getMessage(),false); 
            }
            try {
                for (int idx = 1; idx < 1024; idx++) {
                    myList.add(0,idx);
                }
                myList.minimize();
                assertTrue("Test4.2", myList.size() == myList.capacity());
            } catch (Exception e) {
                assertTrue("Test4.2 -- Unexpected Exception: " + e.getMessage(),false); 
            }
            
        } catch (Exception e) {
            assertTrue("Test4 -- Unexpected Exception: " + e.getMessage(),false); 
        }

        try {
            ArrayList306B<String> myList;
            myList = new ArrayList306B<String>();

            try {
                myList.add(0,"zero");
                myList.minimize();
                assertTrue("Test5.1", myList.size() == myList.capacity());
            } catch (Exception e) {
                assertTrue("Test5.1 -- Unexpected Exception: " + e.getMessage(),false); 
            }
            try {
                myList.add(1,"one");
                myList.add(2,"two");
                myList.add(3,"three");
                myList.minimize();
                assertTrue("Test5.2", myList.size() == myList.capacity());
            } catch (Exception e) {
                assertTrue("Test5.2 -- Unexpected Exception: " + e.getMessage(),false); 
            }
            
        } catch (Exception e) {
            assertTrue("Test5 -- Unexpected Exception: " + e.getMessage(),false); 
        }
    }

    private static void assertTrue(String testName, boolean passed) {
        if (passed) System.out.println(testName + ": Passed!");
        else System.out.println(testName + ": FAILED FAILED FAILED"); 
    } 

}
