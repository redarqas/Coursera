package org.coursera.edu.algorithms;

import java.util.Comparator;

public class UnOrderedPQ<Key extends Comparable<Key>> {

    private Key[] items;
    private int N;

    public UnOrderedPQ() {
        N = 0;
        items = (Key[]) new Comparable[1];
    }

    public void insert(Key k) {
        if (N > items.length / 2) {
            Key[] newItems = (Key[]) new Comparable[2 * items.length];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = null;
            items = newItems;
        }
        items[N++] = k;
    }

    public Key pop() {
        int m = 0;
        for (int i = 0; i < N; i++) {
            if (items[i] != null && items[i].compareTo(items[m]) > 0) {
                m = i;
            }
        }

        Key temp = items[N - 1];
        items[N - 1] = items[m];
        items[m] = temp;

        return items[--N];

    }

    public static void main(String[] args) {
        UnOrderedPQ<Integer> pq = new UnOrderedPQ<Integer>();
        pq.insert(1);
        pq.insert(3);
        pq.insert(2);
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
    }
}
