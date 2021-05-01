public class Sort {
    // Bubble sort is O(n^2)
    public static SortReturn bubble(int[] data) {
        long elements = data.length;
        long comparisons = 0; // track number of comparisons made while sorting
        long swaps = 0;       // track number of element swaps made while sorting

        boolean sorted = false;
        long startTime = System.nanoTime(); // track processing time while sorting
        while (!sorted) {
            sorted = true;
            for (int idx = 1; idx < data.length; idx++) {
                comparisons++; // if statement below represents a comparison
                if (data[idx] < data[idx-1]) {
                    swaps++; // this block is a swap
                    int tmpData = data[idx-1];
                    data[idx-1] = data[idx];
                    data[idx] = tmpData;
                    sorted = false;
                }
            }
        }
        long totalTime = (System.nanoTime() - startTime); // capture final processing time
        // create return object to pass back all collected information
        SortReturn sr = new SortReturn("Bubble Sort",comparisons,swaps,totalTime,elements);
        return sr;
    }

    //Selection sort is O(n^2)
    public static SortReturn selection(int[] data) {
        long elements = data.length;
        long comparisons = 0; // track number of comparisons made while sorting
        long swaps = 0;       // track number of element swaps made while sorting

        long startTime = System.nanoTime(); // track processing time while sorting
        for(int i = 0; i < elements-1; i++){
            int smallest = i;
            for (int j = i +1; j< elements; j++){
                comparisons++;
                if (data[j] < data[smallest]) {
                    smallest = j;
                }
            }
            swaps++;
            int temp = data[i];
            data[i] = data[smallest];
            data[smallest] = temp;
        }
        long totalTime = (System.nanoTime() - startTime); // capture final processing time
        // create return object to pass back all collected information
        return new SortReturn("Selection Sort",comparisons,swaps,totalTime,elements);
    }

    //insertion sort is O(n^2)
    public static SortReturn insertion(int[] data){
        long elements = data.length;
        long comparisons = 0; // track number of comparisons made while sorting
        long swaps = 0;       // track number of element swaps made while sorting

        long startTime = System.nanoTime(); // track processing time while sorting
        for(int i = 1; i<elements; i++){
            int key = data[i];
            int hole = i;
            while(hole > 0 && data[hole-1] > key){
                comparisons++;
                swaps++;
                data[hole] = data[hole-1];
                hole--;
            }
            data[hole] = key;
        }
        long totalTime = (System.nanoTime() - startTime); // capture final processing time
        // create return object to pass back all collected information
        return new SortReturn("Insertion Sort",comparisons,swaps,totalTime,elements);
    }
}
