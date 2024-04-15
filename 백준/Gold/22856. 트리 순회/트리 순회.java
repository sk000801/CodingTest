import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<Node> list = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    static int answer = 0;
    static int lastNode;

    public static class Node {
        int num;
        int left;
        int right;

        public Node(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    public static void newInOrder(int root) {
        Node cur = list.get(root-1);

        visited[cur.num] = true;
        answer++;

        if(cur.left != -1 && !visited[cur.left]) newInOrder(cur.left);
        else if(cur.right != -1 && !visited[cur.right]) newInOrder(cur.right);
        else if(cur.num == lastNode) return;
        else if(parent[cur.num] != -1) newInOrder(parent[cur.num]);
    }

    public static void inOrder(int root) {
        Node cur = list.get(root-1);

        if(cur.left != -1) inOrder(cur.left);

        lastNode = cur.num;

        if(cur.right != -1) inOrder(cur.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        parent = new int[n+1];

        Arrays.fill(parent, -1);

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));

            if(b != -1) parent[b] = a;
            if(c != -1) parent[c] = a;
        }

        list.sort((a, b) -> a.num-b.num);
        
        inOrder(1);

        newInOrder(1);

        System.out.println(answer-1);
    }
}
