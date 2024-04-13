import java.util.*;
import java.io.*;

public class Main {
    static int tc;
    static int n, d, c;
    static int[] dist;
    static boolean[] visited;
    static List<List<Computer>> list;

    public static class Computer implements Comparable<Computer> {
        int comp;
        int second;

        public Computer(int comp, int second) {
            this.comp = comp;
            this.second = second;
        }

        @Override
        public int compareTo(Computer c) {
            return this.second-c.second;
        }
    } 

    public static void dijkstra() {
        PriorityQueue<Computer> q = new PriorityQueue<>();
        q.add(new Computer(c, 0));
        dist[c] = 0;

        while(!q.isEmpty()) {
            Computer cur = q.poll();

            if(visited[cur.comp]) continue;
            visited[cur.comp] = true;

            for(int i = 0; i < list.get(cur.comp).size(); i++) {
                Computer next = list.get(cur.comp).get(i);

                if(dist[next.comp] > dist[cur.comp]+next.second) {
                    dist[next.comp] = dist[cur.comp]+next.second;
                    q.add(new Computer(next.comp, dist[next.comp]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터

            list = new ArrayList<>();
            for(int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }

            dist = new int[n+1];
            visited = new boolean[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for(int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new Computer(a, s));
            }

            dijkstra();

            int answer = 0;
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(dist[j] != Integer.MAX_VALUE) {
                    count++;
                    answer = Math.max(dist[j], answer);
                }
            }

            sb.append(count).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
