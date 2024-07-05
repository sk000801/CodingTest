import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Cow>> list = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static class Cow implements Comparable<Cow> {
        int node;
        int count;

        public Cow(int node, int count) {
            this.node = node;
            this.count = count;
        }

        @Override
        public int compareTo(Cow c) {
            return this.count-c.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        visited = new boolean[n+1];

        dist[1] = 0;

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Cow(b, c));
            list.get(b).add(new Cow(a, c));
        }

        PriorityQueue<Cow> pq = new PriorityQueue<>();
        pq.add(new Cow(1, 0));

        while(!pq.isEmpty()) {
            Cow cur = pq.poll();

            if(visited[cur.node]) continue;
            visited[cur.node] = true;

            for(int i = 0; i < list.get(cur.node).size(); i++) {
                Cow next = list.get(cur.node).get(i);

                dist[next.node] = Math.min(dist[next.node], dist[cur.node]+next.count);
                pq.add(new Cow(next.node, dist[next.node]));
            }
        }

        System.out.println(dist[n]);
    }   
}
