/*This procedural script test that the CharQueueList class is working properly*/
public class TestQueueList { 
     public static void main (String[] args) {

        // Test1
        CharQueueList l1 = new CharQueueList();
        assertTrue("Test1.1", l1.toString().equals("{}") );
        assertTrue("Test1.2", l1.isEmpty()==true);
        assertTrue("Test1.3", l1.size()==0);

        // Test2
        l1.enqueue('h');
        assertTrue("Test2.1", l1.toString().equals("{h}") );
        assertTrue("Test2.2", l1.isEmpty()==false);
        assertTrue("Test2.3", l1.size()==1);

        // Test3
        l1.enqueue('e');
        l1.enqueue('l');
        l1.enqueue('l');
        l1.enqueue('o');
        assertTrue("Test3", l1.toString().equals("{h,e,l,l,o}") );
     

        
        // Test6
        assertTrue("Test6.0", l1.first()=='h');
        assertTrue("Test6.1", l1.dequeue()=='h');
        assertTrue("Test6.2", l1.dequeue()=='e');
        assertTrue("Test6.3", l1.dequeue()=='l');
        assertTrue("Test6.4", l1.toString().equals("{l,o}") );
        assertTrue("Test6.5", l1.isEmpty()==false);
        assertTrue("Test6.6", l1.size()==2);
        assertTrue("Test6.7", l1.dequeue()=='l');
        assertTrue("Test6.8", l1.dequeue()=='o');
        assertTrue("Test6.9", l1.isEmpty()==true);
        assertTrue("Test6.10", l1.size()==0);

        //Test7
        boolean passed = false;
        try {
            l1.dequeue();
        } catch (IllegalStateException ise) {
            passed = true;
        }
        assertTrue("Test7.1", passed);

        passed = false;
        try {
            l1.first();
        } catch (IllegalStateException ise) {
            passed = true;
        }
        assertTrue("Test7.2", passed);

    }

    private static void assertTrue (String testName, boolean passed) {
        if (passed) System.out.println(testName + ":Passed");
        else System.out.println(testName + ":FAILED!"); 
    }

}