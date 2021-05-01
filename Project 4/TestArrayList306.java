
public class TestArrayList306 {

    public static void main(String[] args) {

        try {
            ArrayList306<Integer> myList;
            myList = new ArrayList306<Integer>();
            myList.add(0,3); 
            myList.add(0,1); 
            myList.add(1,2);

            try { 
                myList.add(-1,10);
                assertTrue("Test1.1",false);
            } catch (IndexOutOfBoundsException e) {
                assertTrue("Test1.1",true);
            }
            try {
                myList.add(10,10);
                assertTrue("Test1.2",false);
            } catch (IndexOutOfBoundsException e) {
                assertTrue("Test1.2",true);
            }
            try {
                myList.add(4,10);
                assertTrue("Test1.3",false);
            } catch (IndexOutOfBoundsException e) {
                assertTrue("Test1.3",true);
            }
            try {
                myList.set(3,10);
                assertTrue("Test1.4",false);
            } catch (IndexOutOfBoundsException e) {
                assertTrue("Test1.4",true);
            }
            try {
                myList.set(-1,10);
                assertTrue("Test1.5",false);
            } catch (IndexOutOfBoundsException e) {
                assertTrue("Test1.5",true);
            }
            try {
                myList.get(-1);
                assertTrue("Test1.6",false);
            } catch (IndexOutOfBoundsException e) {
                assertTrue("Test1.6",true);
            }
            try {
                myList.get(3);
                assertTrue("Test1.7",false);
            } catch (IndexOutOfBoundsException e) {
                assertTrue("Test1.7",true);
            }
            try {
                for (int idx = 3; idx < 16; idx++) {
                    myList.add(0,idx);
                }
                myList.add(0,16);
                assertTrue("Test1.8",false);
            } catch (IllegalStateException e) {
                assertTrue("Test1.8",true);
            }            
            assertTrue("Test1.9a", myList.size() == 16);
            myList.remove(15);
            assertTrue("Test1.9b", myList.size() == 15);
            myList.add(0,16);
            assertTrue("Test1.9c", myList.size() == 16);


        } catch (Exception e) {
            assertTrue("Test1 -- Unexpected Exception: " + e.getMessage(),false); 
        }

        try {
            ArrayList306<String> myList;
            myList = new ArrayList306<String>();

            assertTrue("Test2.1", myList.isEmpty());
            assertTrue("Test2.2", myList.size() == 0);

            myList.add(0,"time"); 
            myList.add(0,"AAA"); 
            myList.add(1,"BBB");
            myList.add(0,"now");
            String testReturn = myList.set(1,"is");
            myList.set(2,"the");

            assertTrue("Test2.3", (!myList.isEmpty()) );
            assertTrue("Test2.4", myList.size() == 4);

            assertTrue("Test2.5", myList.get(1).equals("is"));
            assertTrue("Test2.6", myList.remove(1).equals("is"));

            assertTrue("Test2.7", (!myList.isEmpty()) );
            assertTrue("Test2.8", myList.size() == 3);

            assertTrue("Test2.9", myList.get(0).equals("now"));
            assertTrue("Test2.10", myList.remove(0).equals("now"));

            assertTrue("Test2.11", (!myList.isEmpty()) );
            assertTrue("Test2.12", myList.size() == 2);
   
            assertTrue("Test2.13", myList.get(1).equals("time"));
            assertTrue("Test2.14", myList.remove(1).equals("time"));

            assertTrue("Test2.15", (!myList.isEmpty()) );
            assertTrue("Test2.16", myList.size() == 1);
 
            assertTrue("Test2.17", myList.get(0).equals("the"));
            assertTrue("Test2.18", myList.remove(0).equals("the"));

            assertTrue("Test2.19", (myList.isEmpty()) );
            assertTrue("Test2.20", myList.size() == 0);
            assertTrue("Test2.21", testReturn.equals("AAA"));
        } catch (Exception e) {
            assertTrue("Test2 -- Unexpected Exception: " + e.getMessage(),false); 
        }

    }

    private static void assertTrue(String testName, boolean passed) {
        if (passed) System.out.println(testName + ": Passed!");
        else System.out.println(testName + ": FAILED FAILED FAILED"); 
    } 

}
