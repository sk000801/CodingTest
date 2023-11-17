import java.util.*;

public class Main {
    public static class Node {
        String cur;
        Node before, after;
        public Node(String cur, Node before, Node after) {
            this.before = before;
            this.cur = cur;
            this.after = after;
        }
    }

    public static void insert(Node node, String cur, String before, String after) {
        if(node.cur.equals(cur)) {
            node.before = (before.equals(".") ? null : new Node(before, null, null));
            node.after = (after.equals(".") ? null : new Node(after, null, null));
            return;
        } 
            
        if(node.before != null) insert(node.before, cur, before, after);
        if(node.after != null) insert(node.after, cur, before, after);
    }

    public static void preOrder(Node n) {
        if(n == null) {
            return;
        }
        System.out.print(n.cur);
        preOrder(n.before);
        preOrder(n.after);
    }

    public static void inOrder(Node n) {
        if(n == null) {
            return;
        }
        inOrder(n.before);
        System.out.print(n.cur);
        inOrder(n.after);
    }

    public static void postOrder(Node n) {
        if(n == null) {
            return;
        }
        postOrder(n.before);
        postOrder(n.after);
        System.out.print(n.cur);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        Node root = new Node("A", null, null);

        for(int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            insert(root, s[0], s[1], s[2]);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}
