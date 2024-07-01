import java.io.*;

// k개를 포함하는 가장 짧은, 가장 긴 문자열 찾기
// 둘 중에 하나라도 없으면 -1 출력
// 완전탐색하면 시간 복잡도에 걸릴 줄 알았으나 그건 아니였음 (10^6)

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < t; i++) {
            String s = br.readLine();   
            int k = Integer.parseInt(br.readLine());

            if(k == 1) {
                sb.append("1 1\n");
                continue;
            }

            int[] num = new int[26];
            for(int j = 0; j < s.length(); j++) {
                int idx = s.charAt(j)-'a';
                num[idx]++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int j = 0; j <= s.length()-k; j++) {
                char c = s.charAt(j);

                if(num[c-'a'] >= k) {
                    int temp = 1;
                    for(int r = j+1; r < s.length(); r++) {
                        char c2 = s.charAt(r);

                        if(c == c2) temp++;

                        if(temp == k) {
                            min = Math.min(min, r-j+1);
                            max = Math.max(max, r-j+1);
                            break;
                        }
                    }
                }
            }

            if(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                sb.append(min).append(" ").append(max);
            } else {
                sb.append(-1);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
