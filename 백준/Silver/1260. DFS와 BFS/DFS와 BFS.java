import java.io.*;
import java.util.*;

// 순서 보장..?
public class Main {
    static int n, m, v;
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();
    static boolean[] visited;
    
    public static void dfs(int num) {
        visited[num] = true;
        sb.append(num).append(" ");
        
        for(int i = 0; i < list.get(num).size(); i++) {
            int cur = list.get(num).get(i);

            if(!visited[cur]) dfs(cur);
        }
    }

    public static void bfs() {
        visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");

            for(int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);

                if(visited[next]) continue;

                q.add(next);
                visited[next] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        List<List<Integer>> list2 = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            List<Integer> temp = list.get(i);
            Collections.sort(temp);
            
            list2.add(temp);
        }

        list = list2;

        visited = new boolean[n+1];

        dfs(v);
        sb.append("\n");
        bfs();

        System.out.println(sb);
    }
}
