public class Search {
    // linear sort is O(n)
    public static SearchReturn linear (int[] theArray, int searchValue) {
        long comparisons = 0; // track number of comparisons made while searching
        long elements = theArray.length;
        long endTime = 0;

        long startTime  = System.nanoTime(); // track processing time while searching
        for (int idx = 0; idx < elements; idx++) {
            comparisons++;
            if (theArray[idx] == searchValue) {
                endTime = System.nanoTime() - startTime;
                return new SearchReturn("Linear Search", comparisons, endTime, elements, idx);
            }
        }
        endTime = System.nanoTime() - startTime; // capture final processing time

        // create return object to pass back all collected information
        return new SearchReturn("Linear Search", comparisons, endTime, elements, -1);
    }
    //binary search is O(log2n)
    public static SearchReturn binary(int[] theArray, int key){
        long comparisons = 0;  //number of comparisons
        int elements = theArray.length;
        int low = 0;
        int high = elements-1;
        long endTime = 0;

        long startTime = System.nanoTime(); //tracking processing time
        while (low <= high){
            comparisons++;
            int mid = (low+high)/2 ;
            if (theArray[mid] == key) {
                endTime = System.nanoTime() - startTime;
                return new SearchReturn("Binary Search", comparisons, endTime, elements, mid);
            }
            else if (theArray[mid] > key) {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        endTime = System.nanoTime() - startTime; // capture final processing time

        //create return object to pass back all collected information
        return new SearchReturn("Binary Search", comparisons, endTime, elements, -1);

    }
}
