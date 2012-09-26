package org.coursera.edu.algorithms;

public class SymbolTable<Key extends Comparable<Key>, V extends Object> {

    private Key[] keys;
    private V[] values;
    private int N;

    public SymbolTable(int capacity) {
        N = 0;
        keys = (Key[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    public void put(Key k, V value) {
        int rank = rank(k);

        if (!contains(k)) {
            N++;
            keys[rank] = k;
        }

        values[rank] = value;
    }

    public int rank(Key k) {
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (keys[mid] == null)
                return mid;
            int cmp = k.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            }
            else if (cmp > 0) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }

        return lo;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public V get(Key k) {
        if (isEmpty())
            return null;
        int i = rank(k);
        if (i < N && keys[i].compareTo(k) == 0)
            return values[i];
        return null;
    }

    public boolean contains(Key k) {
        for (Key key : keys) {
            if (key != null && key.compareTo(k) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SymbolTable<Integer, String> st = new SymbolTable<Integer, String>(5);
        st.put(1, "Hello");
        st.put(2, "World");
        st.put(1, "Nikhil");
        st.put(3, "India");
        System.out.println(st.get(2));
        System.out.println(st.get(1));
        System.out.println(st.get(3));
    }

}
