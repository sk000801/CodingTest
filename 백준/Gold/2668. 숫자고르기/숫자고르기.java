import java.io.*;
import java.util.*;

// 사이클이 일치하는 숫자를 뽑는 문제
public class Main {
    static int[] num;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;

    public static void dfs(int start, int fin) {
        if(!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], fin);
            visited[num[start]] = false;
        }

        if(num[start] == fin) list.add(fin);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        num = new int[n+1];

        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());            
        }

        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        sb.append(list.size()).append("\n");
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
