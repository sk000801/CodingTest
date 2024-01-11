import java.io.*;
import java.util.*;

//루프노트~리프노드 깊이 합 홀수 -> 성원 승리
//n이 5*10^5개
//BufferedReader와 StringTokenizer의 중요성
public class Main {
    static List<List<Integer>> list;
    static int answer;
    static boolean[] visited;

    public static void dfs(int count, int node) {
        for(int i = 0; i < list.get(node).size(); i++) {
            int next = list.get(node).get(i);

            if(!visited[next]) {
                visited[next] = true;
                dfs(count+1, next);
            }
        }

        if(node != 1 && list.get(node).size() == 1) { //리프노드
            answer += count;
            return;
        }        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        answer = 0;

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);            
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(0, 1);

        System.out.println(answer%2==1 ? "Yes" : "No");
    }
}
