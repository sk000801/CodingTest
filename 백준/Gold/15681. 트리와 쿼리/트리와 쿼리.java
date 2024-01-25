import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>(); //간선
    static List<List<Integer>> tree = new ArrayList<>(); //바로 아래노드
    static int[] parent; //해당 노드의 부모 노드
    static int[] size; //해당 노드를 포함한 자식 노드들의 개수

    public static void makeTree(int root, int val) {
        for(int i = 0; i < list.get(root).size(); i++) {
            int next = list.get(root).get(i);

            if(next != val) {
                tree.get(root).add(next);
                parent[next] = root;
                makeTree(next, root);
            }
        }
    }

    public static void findSub(int node) {
        size[node] = 1;

        for(int i = 0; i < tree.get(node).size(); i++) {
            findSub(tree.get(node).get(i));

            size[node] += size[tree.get(node).get(i)];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        makeTree(r, -1);
        findSub(r);

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            sb.append(size[a]).append("\n");
        }

        System.out.println(sb);
    }
}
