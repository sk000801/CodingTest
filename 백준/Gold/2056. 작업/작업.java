import java.util.*;
import java.io.*;

// 모든 작업을 완료하기 위해 필요한 최소 시간
// 선행관계에 있는 작업이 하나도 없는 작업이 하나 이상 존재
public class Main {
    static int n;
    static int[] times;
    static int[] indegree;
    static int[] result;
    static List<List<Integer>> list = new ArrayList<>();

    public static void sort() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            result[i] = times[i];

            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);

                result[next] = Math.max(result[next], times[next]+result[cur]);

                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        times = new int[n+1];
        indegree = new int[n+1];
        result = new int[n+1];
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            int num = Integer.parseInt(st.nextToken());
            
            for(int j = 0; j < num; j++) {
                list.get(Integer.parseInt(st.nextToken())).add(i);

                indegree[i]++;
            }
        }

        sort();

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer);
    }
}
