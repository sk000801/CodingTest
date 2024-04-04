import java.util.*;
import java.io.*;

// 결국 평균 = w/(리프노드 수)
public class Main {
    static int n, w;
    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(tree.get(i).size() == 1) count++;
        }

        System.out.println((double)w/count);
    }
}
