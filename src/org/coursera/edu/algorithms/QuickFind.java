package org.coursera.edu.algorithms;

public class QuickFind extends QuickBaseData implements QuickInterface {

    public QuickFind(int N) {
        super(N);
    }

    private void connect(int p, int q) {
        id[p] = id[q];
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                connect(i, q);
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        qf.union(7, 0);
        qf.union(7, 1);
        qf.union(3, 4);
        qf.union(3, 8);
        qf.union(8, 7);
        qf.union(6, 3);
        System.out.println(qf.toString());

    }

}
