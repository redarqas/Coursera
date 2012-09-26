/**
 * 
 */
package org.coursera.edu.algorithms;

/**
 * @author nikhilshirahatti
 */
public class QuickBaseData {

    protected int[] id;

    public QuickBaseData(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : id) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }

}
