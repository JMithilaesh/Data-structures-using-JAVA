public class SearchReturn {
    private String description;
    private long comparisons = 0;
    private long time = 0;
    private long elements = 0;
    private long index = 0;

    public SearchReturn(String description, long comparisons, long time, long elements, long index) {
        this.description = description;
        this.comparisons = comparisons;
        this.time = time;
        this.elements = elements;
        this.index = index;
    }

    public String toString() {
        return this.description + ":\n" +
                "Elements: " + this.elements + "\n" +
                "Comparisons: " + this.comparisons + "\n" +
                "Index: " + this.index + "\n" +
                "Time: " + this.time + "\n";
    }
}
