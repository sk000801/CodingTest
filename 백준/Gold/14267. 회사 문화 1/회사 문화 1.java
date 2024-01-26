import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] score;

    //재귀적으로 부하 직원들에게 상사 직원의 점수 더해줌
    public static void cal(int root) {
        for(int i = 0; i < tree.get(root).size(); i++) {
            int node = tree.get(root).get(i);
            score[node] += score[root];
            cal(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        score = new int[n+1];

        st = new StringTokenizer(br.readLine());
        //상급자 자리에 부하 직원 번호 넣어둠
        for(int i = 1; i <= n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(node == -1) continue;
            tree.get(node).add(i);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            score[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        cal(1);

        for(int i = 1; i <= n; i++) {
            System.out.print(score[i]+" ");
        }
    }   
}
