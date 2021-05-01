/*This procedural script test that the CharStack class is working properly*/
public class TestStack { 
     public static void main (String[] args) {

        // Test1
        CharStack l1 = new CharStack();
        assertTrue("Test1.1", l1.toString().equals("{}") );
        assertTrue("Test1.2", l1.isEmpty()==true);
        assertTrue("Test1.3", l1.size()==0);

        // Test2
        l1.push('h');
        assertTrue("Test2.1", l1.toString().equals("{h}") );
        assertTrue("Test2.2", l1.isEmpty()==false);
        assertTrue("Test2.3", l1.size()==1);

        // Test3
        l1.push('e');
        l1.push('l');
        l1.push('l');
        l1.push('o');
        assertTrue("Test3", l1.toString().equals("{o,l,l,e,h}") );

        
        // Test6
        assertTrue("Test6.0", l1.top()=='o');
        assertTrue("Test6.1", l1.pop()=='o');
        assertTrue("Test6.2", l1.pop()=='l');
        assertTrue("Test6.3", l1.pop()=='l');
        assertTrue("Test6.4", l1.toString().equals("{e,h}") );
        
        assertTrue("Test6.5", l1.isEmpty()==false);
        assertTrue("Test6.6", l1.size()==2);
        assertTrue("Test6.7", l1.pop()=='e');
        assertTrue("Test6.8", l1.pop()=='h');
        assertTrue("Test6.9", l1.isEmpty()==true);
        assertTrue("Test6.10", l1.size()==0);

        //Test7
        boolean passed = false;
        try {
            l1.pop();
        } catch (IllegalStateException ise) {
            passed = true;
        }
        assertTrue("Test7.1", passed);

        passed = false;
        try {
            l1.top();
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