/**
 * 
 */
package org.coursera.edu.algorithms;

/**
 * @author nikhilshirahatti
 *
 */
public class QuickUnion extends QuickBaseData implements QuickInterface {

	
	public QuickUnion(int N) {
		super(N);
	}

	private int root(int i) {
		
		while( i != id[i]) {
			i = id[i];
		}
		return i;
	}
	
	@Override
	public void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		id[rootp] = rootq;
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickUnion qf = new QuickUnion(10);
		qf.union(2, 3);
		qf.union(8,  3);
		qf.union(5, 4);
		qf.union(5, 2);
		qf.union(6, 7);
		qf.union(8, 1);
		System.out.println(qf.toString());

	}

}
