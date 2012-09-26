package org.coursera.edu.algorithms;

import java.util.LinkedList;
import java.util.Queue;


public class RBTree<Key extends Comparable<Key>, Value> {

    public enum COLOR {RED, BLACK};
    
    private Node root;
    
    public RBTree() {
    
    }
    
    public void insert(Key k, Value v) {
        root = put(root, k, v);
    }
    
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = COLOR.RED;
        return x;
        
    }
    
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = COLOR.RED;
        return x;
    }
    
    public void flipColors(Node h) {
        h.color = COLOR.RED;
        h.left.color = COLOR.BLACK;
        h.right.color = COLOR.BLACK;
    }
    
    public int rank(Key k) {
        return rank(root, k);
    }

    private int rank(Node x, Key k) {

        if (x == null)
            return 0;

        int cmp = k.compareTo(x.key);

        if (cmp == 0) {
            return size(x.left);
        }
        else if (cmp < 0) {
            return rank(x.left, k);
        }
        else {
            return 1 + size(x.left) + rank(x.right, k);
        }
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return size(x.left) + 1 + size(x.right);
    }

    public int size() {
        return size(root);
    }

    public Key floor(Key k) {
        Node x = floor(root, k);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key k) {

        if (x == null)
            return null;

        int cmp = k.compareTo(x.key);

        if (cmp == 0)
            return x;

        if (cmp < 0)
            return floor(x.left, k);

        Node r = floor(x.right, k);
        if (r != null)
            return r;
        else
            return x;
    }

    public Node min() {
        return min(root);
    }

    private Node min(Node x) {
        if (x == null)
            return null;
        while (x != null && x.left != null)
            return min(x.left);
        return x;
    }

    public Value get(Key k) {
        if (root == null) {
            return null;
        }

        Node x = root;

        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            }
            else if (cmp > 0) {
                x = x.right;
            }
            else {
                return x.value;
            }
        }

        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> kq = new LinkedList<Key>();
        inorder(root, kq);
        return kq;
    }
    
    private void inorder(Node x, Queue<Key> kq) {
        if (x == null) {
            return;
        }
        inorder(x.left, kq);
        kq.add(x.key);
        inorder(x.right, kq);
    }

    public void delete(Key k) {
        root = hibbardDelete(root, k);
    }

    private Node hibbardDelete(Node x, Key k) {

        if (x == null)
            return null;

        int cmp = k.compareTo(x.key);

        if (cmp < 0)
            hibbardDelete(x.left, k);

        else if (cmp > 0)
            hibbardDelete(x.right, k);

        else {
            if (x.right == null)
                return x.left;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {

        if (x == null)
            return null;
        if (x.left == null)
            return x.right;

        x.left = deleteMin(x.left);
        return x;

    }
    
    private class Node {
        private Key key;
        private Value value;
        private COLOR color;
        Node left, right;
        
        Node(Key k, Value v, COLOR c) {
            this.key = k;
            this.value = v;
            this.color = c;
        }
    }
    

    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == COLOR.RED;
    }
   
    
    public Node put(Node x, Key k, Value v) {
        if (x == null) {
            return new Node(k, v, COLOR.RED);
        }

        int cmp = k.compareTo(root.key);
        if (cmp < 0) {
            x.left = put(x.left, k, v);
        }
        else if (cmp > 0) {
            x.right = put(x.right, k, v);
        }
        else {
            x.value = v;
        }

        // 3 cases
        // left black, right red : rotateleft
        // left red, left-left red: rotateright
        // left red, right red: flip color
        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right)) flipColors(x);
        
        return x;

    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        RBTree<Integer, String> rb = new RBTree<Integer, String>();
        rb.insert(3, "Hello");
        rb.insert(2, "World");
        rb.insert(1, "!");
        rb.insert(4, "You");
        Iterable<Integer> keys = rb.keys();

        System.out.println(rb.get(2));
        System.out.println(rb.floor(2));
        System.out.println(rb.size());
        System.out.println(rb.rank(2));

        for (int k : keys) {
            System.out.println(k);
        }


    }

}
