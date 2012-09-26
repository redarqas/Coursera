package org.coursera.edu.algorithms;

public class SelectionSort {

    public static void sort(int items[]) {
        for (int i = 0; i < items.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < items.length; j++) {
                if (items[minIndex] > items[j]) {
                    minIndex = j;
                }
            }

            SortHelper.swap(items, i, minIndex);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int array[] = { 5, 3, 2, 1, 9, 7, 8, 0, 4, 6 };

        SelectionSort.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
