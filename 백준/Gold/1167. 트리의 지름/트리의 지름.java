import java.util.*;
// 그냥 모든 거리를 탐색하려 했지만 시간 복잡도에서 걸린다니...
// 임의의 정점과 가장 먼 정점을 찾고 
// 그 정점과 가장 먼 정점 간의 거리를 찾는다 (이게 최대)
public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static int targetNode;
    static int ans = 0;

    public static class Node {
        int dot, dist;
        public Node(int dot, int dist) {
            this.dot = dot;
            this.dist = dist;
        }
    }

    public static void dfs(int node, int len) {
        if(len > ans) {
            ans = len;
            targetNode = node;
        }

        visited[node] = true;

        for(int i = 0; i < list.get(node).size(); i++) {
            Node cur = list.get(node).get(i);

            if(!visited[cur.dot]) {
                visited[cur.dot] = true;
                dfs(cur.dot, cur.dist+len);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            int standard = in.nextInt();
            while(true) {
                int dot = in.nextInt();
                if(dot == -1) break;
                int dist = in.nextInt();

                list.get(standard).add(new Node(dot, dist));
            }
        }

        dfs(1, 0);

        visited = new boolean[n+1];

        dfs(targetNode, 0);

        System.out.println(ans);
    }
}