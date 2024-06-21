import java.io.*;
import java.util.*;

// 단방향 멍청아
public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] dist;
    static List<Integer> answer = new ArrayList<>();

    public static void find(int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(dist[cur] > k) break;
            if(dist[cur] == k) answer.add(cur);

            for(int i = 0; i < list.get(cur).size(); i++) {
                int node = list.get(cur).get(i);

                if(dist[node] != Integer.MAX_VALUE) continue;

                dist[node] = dist[cur]+1;
                q.add(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[x] = 0;

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            //list.get(b).add(a);
        }

        find(k, x);

        if(answer.isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuffer sb = new StringBuffer();
        Collections.sort(answer);

        for(int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
