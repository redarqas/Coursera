package org.coursera.edu.algorithms;

public class QuickUnionWeighted extends QuickBaseData implements QuickInterface {

    int[] sz;

    public QuickUnionWeighted(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        }
        else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        QuickUnionWeighted qw = new QuickUnionWeighted(10);
        qw.union(8, 7);
        qw.union(3, 1);
        qw.union(4, 3);
        qw.union(0, 9);
        qw.union(9, 2);
        qw.union(0, 6);
        qw.union(5, 6);
        qw.union(7, 1);
        qw.union(9, 3);
        System.out.println(qw.toString());

    }

}
