package org.coursera.edu.algorithms;

public class SortHelper {

    public static void swap(int[] items, int i, int minIndex) {
        int temp = items[i];
        items[i] = items[minIndex];
        items[minIndex] = temp;
    }

    public static boolean isSorted(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[i] > items[j])
                    return false;
            }
        }

        return true;
    }

}
