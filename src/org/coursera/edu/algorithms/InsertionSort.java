package org.coursera.edu.algorithms;

public class InsertionSort {

    public static void sort(int[] items) {

        for (int i = 0; i < items.length; i++) {
            for (int j = i; j > 0; j--) {
                if (items[j] < items[j - 1]) {
                    SortHelper.swap(items, j, j - 1);
                }
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int array[] = { 5, 3, 2, 1, 9, 7, 8, 0, 4, 6 };

        InsertionSort.sort(array);
        for (int i : array) {
            System.out.println(i);
        }

    }

}
