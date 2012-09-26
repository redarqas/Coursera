package org.coursera.edu.perf;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: Timing.java

import java.util.Random;

public class Timing {

    public Timing() {
    }

    private static long constant(int i) {
        long l = 0L;
        for (int j = 0; j < i; j++)
            l++;

        return l;
    }

    private static long logarithmic(int i, int j) {
        long l = 0L;
        for (int k = 1; k + k <= i; k += k)
            l += constant(j);

        return l;
    }

    private static long sqrt(int i, int j) {
        long l = 0L;
        int k = 0;
        for (int i1 = 0; i1 < i;) {
            l += constant(j);
            i1 += k;
            k++;
        }

        return l;
    }

    public static long linearithmic(int i, int j) {
        if (i == 0)
            return 0L;
        long l = 0L;
        for (int k = 0; k < i; k++)
            l += constant(j);

        return linearithmic(i / 2, j) + l + linearithmic(i / 2, j);
    }

    private static long linear(int i, int j) {
        long l = 0L;
        for (int k = 0; k < i; k++)
            l += constant(j);

        return l;
    }

    private static long linearsqrt(int i, int j) {
        long l = 0L;
        for (int k = 0; k < i; k++)
            l += sqrt(i, j);

        return l;
    }

    private static long quadratic(int i, int j) {
        long l = 0L;
        for (int k = 0; k < i; k++) {
            for (int i1 = 0; i1 < i; i1++)
                l += constant(j);

        }

        return l;
    }

    private static long exponential(int i, int j) {
        if (i == 0)
            return constant(j);
        else
            return exponential(i - 1, j) + exponential(i - 1, j);
    }

    private static long factorial(int i, int j) {
        if (i == 0)
            return constant(j);
        long l = 0L;
        for (int k = 0; k < i; k++)
            l += factorial(i - 1, j);

        return l;
    }

    private static long divideAndConquer(int i, int j, int k, int l) {
        if (i == 0)
            return 0L;
        long l1 = constant(j);
        for (int i1 = 0; i1 < k; i1++)
            l1 += divideAndConquer(i / l, j, k, l);

        return l1;
    }

    private static long powerLaw(int i, int j, double d) {
        long l = 0L;
        for (long l1 = 0L; (double) l1 < Math.pow(i, d); l1++)
            l += constant(j);

        return l;
    }

    public static void trial(int i, long l) {
        if (i <= 0)
            throw new IllegalArgumentException("N must be a positive integer");
        if (l <= 0L)
            throw new IllegalArgumentException("seed must be a positive integer");
        Random random = new Random(l);
        int j = 1 + random.nextInt(20);
        double d = 1.2D + 2.1000000000000001D * random.nextDouble();
        byte byte0 = 15;
        int k = 0;
        int i1 = 1;
        int j1 = 1;
        int k1 = 0;
        int l1 = k;
        int j2 = i1;
        double d1 = Math.abs(d);
        int l2;
        int i3;
        do {
            l2 = k + j1;
            i3 = i1 + k1;
            double d2 = (double) l2 / (double) i3;
            if (d < d2) {
                j1 = l2;
                k1 = i3;
            }
            else {
                k = l2;
                i1 = i3;
            }
            double d3 = Math.abs(d2 - d);
            if (d3 < d1) {
                int i2 = l2;
                int k2 = i3;
                d1 = d3;
            }
        }
        while (i1 + k1 <= byte0);
        d = (double) l2 / (double) i3;
        long l3 = powerLaw(i, j, d);
        counter += l3;
    }

    public static void main(String args[]) {
        int i = 0;
        int j = 0;
        if (args.length != 2) {
            System.out
                    .println("You must supply two postive integer command-line arguments: N and seed");
            return;
        }
        try {
            i = Integer.parseInt(args[0]);
            j = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException numberformatexception) {
            System.out
                    .println("You must supply two postive integer command-line arguments: N and seed");
            return;
        }
        trial(i, j);
    }

    private static long counter = 0L;

}
