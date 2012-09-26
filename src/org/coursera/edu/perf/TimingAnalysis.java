package org.coursera.edu.perf;

import edu.princeton.cs.algs4.Stopwatch;

public class TimingAnalysis {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double T[] = new double[9];
        int N[] = new int[9];
        for (int i = 1, idx = 0; i <= 256; i *= 2) {
            N[idx] = i;
            Stopwatch sw = new Stopwatch();
            Timing.trial(i, 811328);
            double t = sw.elapsedTime();
            T[idx++] = t;
            System.out.println(String.format("%d %f", i, t));
        }

        System.out.println(Math.log(T[5] / T[4]));
    }

}
