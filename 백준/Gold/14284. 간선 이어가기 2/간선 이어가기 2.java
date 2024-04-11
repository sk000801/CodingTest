import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<List<Point>> list = new ArrayList<>();

    public static class Point implements Comparable<Point> {
        int node;
        int value;

        public Point(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Point p) {
            return this.value-p.value;
        }
    }

    public static int find(int a, int b) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(new Point(a, 0));
        dist[a] = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(visited[p.node]) continue;
            visited[p.node] = true;

            for(int i = 0; i < list.get(p.node).size(); i++) {
                Point cur = list.get(p.node).get(i);

                if(dist[cur.node]  > dist[p.node]+cur.value) {
                    dist[cur.node] = dist[p.node]+cur.value;
                    q.add(new Point(cur.node, dist[cur.node]));
                }
            }
        }

        return dist[b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<Point>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Point(b, c));
            list.get(b).add(new Point(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(find(a, b));
    }
}
