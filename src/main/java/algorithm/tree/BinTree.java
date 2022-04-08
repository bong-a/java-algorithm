package algorithm.tree;

import java.util.Comparator;

public class BinTree<K, V> {

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public static void main(String[] args) {
        BinTree<Integer, String> binTree = new BinTree<>();

    }

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int comp(K key1, K key2) {
        return (comparator == null ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2));
    }

    public V search(K key) {
        Node<K, V> p = root;

        while (true) {
            if (p == null) {
                return null;
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) {
                return p.getValue();
            } else if (cond < 0) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
    }

    public void add(K key, V data) {
        if (root == null) {
            root = new Node<>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }

    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0) {
            return;
        } else if (cond < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(key, data, null, null));
            } else {
                addNode(node.getLeft(), key, data);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(key, data, null, null));
            } else {
                addNode(node.getRight(), key, data);
            }
        }
    }

    public boolean remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (p == null) {
                return false;
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) {
                break;
            } else {
                parent = p;
                if (cond < 0) {
                    isLeftChild = true;
                    p = p.getLeft();
                } else {
                    isLeftChild = false;
                    p = p.getRight();
                }
            }
        }
        if (p.getLeft() == null) {
            if (p == root) {
                root = p.getRight();
            } else if (isLeftChild) {
                parent.setLeft(p.getRight());
            } else {
                parent.setRight(p.getRight());
            }
        } else if (p.getRight() == null) {
            if (p == root) {
                root = p.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(p.getLeft());
            } else {
                parent.setRight(p.getLeft());
            }
        } else {
            parent = p;
            Node<K, V> left = p.getLeft();
            isLeftChild = true;
            while (left.getRight() != null) {
                parent = left;
                left = left.getRight();
                isLeftChild = false;
            }
            p.setKey(left.getKey());
            p.setValue(left.getValue());
            if (isLeftChild) {
                parent.setLeft(left.getLeft());
            } else {
                parent.setRight(left.getLeft());
            }
        }
        return true;
    }

    private void printSubTree(Node<K, V> node) {
        if (node != null) {
            printSubTree(node.getLeft());
            System.out.println(node.getKey() + " " + node.getValue());
            printSubTree(node.getRight());
        }
    }

    public void print() {
        printSubTree(root);
    }

}
