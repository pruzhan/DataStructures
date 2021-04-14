package TreeHeight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        int[] parent = new int[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            parent[i] = sc.nextInt();
            if (parent[i]==-1) root = i;
        }
        for (int i = 0; i < n; i++) {
            if (parent[i]==-1) nodes[i].parent=null;
            else {
                nodes[parent[i]].children.add(nodes[i]);
                nodes[i].parent = nodes[parent[i]];
            }
        }
        Tree tree = new Tree(nodes[root]);
        System.out.println(tree.height(tree.root));
    }
}

class Tree {
    public Node root;

    public Tree(Node rootData) {
        this.root = rootData;
    }

    public int height(Node t) {
        int height = 1;
        for (Node child : t.children) height = Math.max(height, 1+height(child));
        return height;
    }
}

class Node {
    public int key;
    public Node parent;
    public List<Node> children;

    public Node(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }
}