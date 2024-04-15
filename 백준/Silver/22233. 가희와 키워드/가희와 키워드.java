import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            set.add(s);
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(",");

            for(int j = 0; j < s.length; j++) {
                set.remove(s[j]);
            }

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}
