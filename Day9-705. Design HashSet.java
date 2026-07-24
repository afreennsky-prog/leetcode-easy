import java.util.*;

class MyHashSet {
    private final int SIZE = 1000;
    private List<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(int key) {
        // Math.abs handles negative key values safely
        return Math.abs(key) % SIZE; 
    }

    public void add(int key) {
        int index = getIndex(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        // Explicit cast to (Integer) is correct so object removal is triggered
        buckets[index].remove((Integer) key);
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        return buckets[index].contains(key);
    }
}
