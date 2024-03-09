import java.util.*;
import java.io.*;

// 문제 잘못이해했네
// 옆에 붙어있는 것만 swap
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> num = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            int maxIdx = -1;
            int maxVal = 0;

            for(int j = i+1; j < n; j++) {
                if(num.get(i) < num.get(j) && s >= j-i) {
                    if(num.get(j) > maxVal) {
                        maxIdx = j;
                        maxVal = num.get(j);
                    }
                }
            }

            if(maxIdx != -1) {
                num.remove(maxIdx);
                num.add(i, maxVal);
                s -= (maxIdx-i);
            }            
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(num.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
