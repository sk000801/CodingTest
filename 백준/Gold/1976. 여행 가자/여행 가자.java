import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] dest;

    public static void bfs(int start, int fin) {
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n+1];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);

                if(next == fin) return;
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        System.out.println("NO");
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            if(i == 0) continue;
            
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(val == 1) list.get(i).add(j);
                if(i == j) list.get(i).add(i);
            }
        }

        dest = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {    
            dest[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m-1; i++) {
            bfs(dest[i], dest[i+1]);
        }

        System.out.println("YES");
    }
}
