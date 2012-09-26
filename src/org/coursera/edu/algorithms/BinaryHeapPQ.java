package org.coursera.edu.algorithms;

public class BinaryHeapPQ<Key extends Comparable<Key>> {

    private Key[] items;
    private int numItems;

    public BinaryHeapPQ() {
        numItems = 0;
        items = (Key[]) new Comparable[2];
    }

    public Key get(int i) {
        return items[i];
    }

    public void sort() {
        for (int k = numItems / 2; k >= 1; k--) {
            sink(k);
        }

        while (numItems > 1) {
            exchange(1, numItems);
            --numItems;
            sink(1);
        }
    }

    public void swim(int k) {
        while (k > 1 && items[k / 2].compareTo(items[k]) < 0) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void exchange(int j, int i) {
        Key t = items[j];
        items[j] = items[i];
        items[i] = t;
    }

    public void sink(int k) {
        while (2 * k <= numItems) {
            int i = 2 * k;
            if (i < numItems && items[i].compareTo(items[i + 1]) < 0)
                i++;
            if (items[k].compareTo(items[i]) > 0)
                break;
            exchange(k, i);
            k = i;
        }
    }

    public void insert(Key k) {
        if (numItems >= items.length / 2) {
            Key[] newItems = (Key[]) new Comparable[2 * items.length];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = null;
            items = newItems;
        }
        items[++numItems] = k;
        swim(numItems);
    }

    public Key pop() {
        Key r = items[1];
        exchange(1, numItems--);
        sink(1);
        items[numItems + 1] = null;
        return r;
    }

    public static void main(String[] args) {
        BinaryHeapPQ<Integer> pq = new BinaryHeapPQ<Integer>();
        pq.insert(8);
        pq.insert(3);
        pq.insert(2);
        pq.insert(4);
        pq.sort();
        for (int i = 1; i < 5; i++) {
            System.out.println(pq.get(i));
        }
        // System.out.println(pq.pop());
        // System.out.println(pq.pop());
        // System.out.println(pq.pop());
    }
}
