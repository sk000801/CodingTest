import java.util.*;
import java.io.*;

public class Main {
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for(int j = 0; j < s.length(); j++) {
                set.add(s.substring(0, j+1));
            }
        }

        int answer = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(set.contains(s)) answer++;
        }

        System.out.println(answer);
    }
}
