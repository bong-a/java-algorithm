package Q07;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
    private Node root;

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        System.out.println(tree.BFS(0, tree.root));
    }

    public int BFS(int level, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.lt == null && node.rt == null) {
                    return level;
                } else {
                    if (node.lt != null) {
                        queue.offer(node.lt);
                    }
                    if (node.rt != null) {
                        queue.offer(node.rt);
                    }
                    level = level + 1;
                }
            }
        }
        return level;
    }
}
