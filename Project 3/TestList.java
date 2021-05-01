public class TestList { 
     public static void main (String[] args) {

        // Test1
        CharList l1 = new CharList();
        assertTrue("Test1.1", l1.toString().equals("{}") );
        assertTrue("Test1.2", l1.isEmpty()==true);
        assertTrue("Test1.3", l1.size()==0);

        // Test2
        l1.addToTail('h');
        assertTrue("Test2.1", l1.toString().equals("{h}") );
        assertTrue("Test2.2", l1.isEmpty()==false);
        assertTrue("Test2.3", l1.size()==1);

        // Test3
        l1.addToHead('e');
        l1.addToHead('l');
        l1.addToHead('l');
        l1.addToHead('o');
        
        assertTrue("Test3", l1.toString().equals("{o,l,l,e,h}") );
        
       
        // Test4
        l1.sort();
        assertTrue("Test4", l1.toString().equals("{e,h,l,l,o}") );
        
     
        // Test5
        l1.addToTail(' ');
        l1.addToTail('w');
        l1.addToTail('o');
        l1.addToTail('r');
        l1.addToTail('l');
        l1.addToTail('d');
        assertTrue("Test5", l1.toString().equals("{e,h,l,l,o, ,w,o,r,l,d}") );
       
      
        
        // Test6
        assertTrue("Test6.1", l1.remove()=='e');
        assertTrue("Test6.2", l1.remove()=='h');
        assertTrue("Test6.3", l1.remove()=='l');
        assertTrue("Test6.4", l1.toString().equals("{l,o, ,w,o,r,l,d}") );
        assertTrue("Test6.5", l1.isEmpty()==false);
        assertTrue("Test6.6", l1.size()==8);


        //Test7
        boolean passed = false;
        CharList l2 = new CharList();
        try {
            l2.remove();
        } catch (IllegalStateException ise) {
            passed = true;
        }
        assertTrue("Test7.1", passed);

        passed = false;
        try {
            l2.addToHead('t');
            l2.remove();
            l2.remove();
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