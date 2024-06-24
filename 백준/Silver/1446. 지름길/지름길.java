import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i <= 10000; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int fin = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            // 지름길을 가는게 더 이득일 때
            if(fin-start > len) list.get(fin).add(new int[]{start, len});
        }

        dist[0] = 0;

        for(int i = 1; i <= d; i++) {
            if(list.get(i).size() > 0) {
                // 지름길이 있다면 지름길을 거치는 경우만 고려
                for(int j = 0; j < list.get(i).size(); j++) {
                    int[] next = list.get(i).get(j);

                    if(dist[next[0]]+next[1] > dist[i]) continue;
                    dist[i] = Math.min(dist[i-1]+1, dist[next[0]]+next[1]);
                }
                continue;
            }
            dist[i] = dist[i-1]+1;
        }

        System.out.println(dist[d]);
    }
}
