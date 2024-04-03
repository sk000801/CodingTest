import java.util.*;
import java.io.*;

// LCA를 찾기 위해서 루트 노드(1)를 기준으로 DFS 탐색을 해야함
public class Main {
    static int n, m;
    static List<List<Integer>> list  = new ArrayList<>();
    static int[] parent;
    static int[] depth;

    public static void init(int cur, int height, int p) {
        depth[cur] = height;
        parent[cur] = p;

        for(int i = 0; i < list.get(cur).size(); i++) {
            int num = list.get(cur).get(i);

            if(num != p) init(num, height+1, cur);
        }
    }

    public static int find(int a, int b) {
        int height1 = depth[a];
        int height2 = depth[b];

        while(height1 > height2) {
            a = parent[a];
            height1--;
        }   

        while(height1 < height2) {
            b = parent[b];
            height2--;
        }

        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        depth = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        init(1, 1, 0);

        m = Integer.parseInt(br.readLine());
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(find(a, b)).append("\n");
        }

        System.out.println(sb);
    }
}
