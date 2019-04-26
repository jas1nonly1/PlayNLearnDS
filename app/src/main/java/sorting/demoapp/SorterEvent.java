package sorting.demoapp;

public class SorterEvent<T extends Comparable<T>> {
    private final Sorter<T> source;
    public SorterEvent(Sorter<T> source) {
            this.source = source;
    }
    
    /**
     * The source of the event.
     * @return Reference to the sorter object.
     */
    public Sorter<T> getSource() {
            return source;
    }
}
