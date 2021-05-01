import java.util.Random;
public class TestSearchAndSort {
    public static void main(String[] args) {
        //displaying sorting algorithm results
        displayBubble();
        displaySelection();
        displayInsertion();
        //displaying linear and binary search results
        displaySearchAlgos();
    }

    // this method will display the array contents if you want to view them
    private static void displayArray(int[] testData) {
        for (int theInt : testData) {
            System.out.print(theInt + ",");
        }
        System.out.println();
    }

    private static void displayBinary(int[] testData, int size) {
        SearchReturn srchReturn;
        SortReturn sr = Sort.bubble(testData); //sorting the array for binary search

        // Search for an element that is known to be in the 10% position
        srchReturn = Search.binary(testData, testData[size / 10]);
        System.out.println("Binary Search 10% \n" + srchReturn.toString()); // display the performance info

        // Search for an element that is known to be in the 50% position
        srchReturn = Search.binary(testData, testData[size / 2]);
        System.out.println("Binary Search 50% \n" + srchReturn.toString()); // display the performance info

        // Search for an element that is known to be in the 90% position
        srchReturn = Search.binary(testData, testData[(int) (size * 0.9)]);
        System.out.println("Binary Search 90% \n" + srchReturn.toString()); // display the performance info

        // Search for an element that is known not to exist (
        srchReturn = Search.binary(testData, 9999);
        System.out.println("Binary Search Not Found \n" + srchReturn.toString()); // display the performance info
    }

    private static void displayLinear(int[] testData, int size) {
        SearchReturn srchReturn;
        // Search for an element that is known to be in the 10% position
        srchReturn = Search.linear(testData, testData[size / 10]);
        System.out.println("Linear Search 10% \n" + srchReturn.toString()); // display the performance info

        // Search for an element that is known to be in the 50% position
        srchReturn = Search.linear(testData, testData[size / 2]);
        System.out.println("Linear Search 50% \n" + srchReturn.toString()); // display the performance info

        // Search for an element that is known to be in the 90% position
        srchReturn = Search.linear(testData, testData[(int) (size * 0.9)]);
        System.out.println("Linear Search 90% \n" + srchReturn.toString()); // display the performance info

        // Search for an element that is known not to exist (
        srchReturn = Search.linear(testData, 9999);
        System.out.println("Linear Search Not Found \n" + srchReturn.toString()); // display the performance info
    }

    private static void displaySearchAlgos() {
        int size = 100; // initial size of array
        //this loop creates arrays of 100, 1,000, & 10,000 and applies linear and binary search to them
        while (size <= 10000) {
            int[] testData = new int[size];
            Random rndm = new Random(); // use a Random object to generate data
            for (int idx = 0; idx < size; idx++) {
                testData[idx] = rndm.nextInt(1000); // Random integers between 0 & 1000
            }
            //displaying linear search
            displayLinear(testData, size);
            //displaying binary search
            displayBinary(testData, size);
            size *= 10;
        }
    }

    private static void displayBubble() {
        int size = 100; // initial size of array
        //this loop creates arrays of 100, 1,000, & 10,000 and applies bubble
        while (size <= 10000) {
            int[] testData = new int[size];
            Random rndm = new Random(); // use a Random object to generate data
            for (int idx = 0; idx < size; idx++) {
                testData[idx] = rndm.nextInt(1000); // Random integers between 0 & 1000
            }
            //sort the array with bubble sort and print results
            SortReturn sr = Sort.bubble(testData);
            System.out.println(sr.toString());
            size *= 10;
        }
    }

    private static void displaySelection() {
        int size = 100; // initial size of array
        //this loop creates arrays of 100, 1,000, & 10,000 and applies selection sort to them
        while (size <= 10000) {
            int[] testData = new int[size];
            Random rndm = new Random(); // use a Random object to generate data
            for (int idx = 0; idx < size; idx++) {
                testData[idx] = rndm.nextInt(1000); // Random integers between 0 & 1000
            }
            //sort the array with selection sort and print results
            SortReturn sr = Sort.selection(testData);
            System.out.println(sr.toString());
            size *= 10;
        }
    }
    private static void displayInsertion() {
        int size = 100; // initial size of array
        //this loop creates arrays of 100, 1,000, & 10,000 and applies insertion sort to them
        while (size <= 10000) {
            int[] testData = new int[size];
            Random rndm = new Random(); // use a Random object to generate data
            for (int idx = 0; idx < size; idx++) {
                testData[idx] = rndm.nextInt(1000); // Random integers between 0 & 1000
            }
            //sort the array with insertion sort and print results
            SortReturn sr = Sort.insertion(testData);
            System.out.println(sr.toString());
            size *= 10;
        }
    }
}
