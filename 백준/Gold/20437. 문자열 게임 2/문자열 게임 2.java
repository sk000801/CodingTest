import java.io.*;

//와 투 포인터 사용했는데 그게 아니라 알파벳 별 개수를 저장하는게 좋음
//시간초과 발생한대...
//그리고 완전탐색 진행
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            if(k == 1) {
                sb.append("1 1").append("\n");
                continue;
            }

            int[] alpha = new int[26]; 
            for(int j = 0; j < w.length(); j++) {
                //char a가 아스키코드 97번
                alpha[w.charAt(j)-97]++;
            }

            for(int j = 0; j <= w.length()-k; j++) {
                char start = w.charAt(j);

                if(alpha[start-97] >= k) {
                    int temp = 1;
                    for(int r = j+1; r < w.length(); r++) {
                        char cur = w.charAt(r);
                        if(start == cur) temp++;

                        if(temp == k) {
                            min = Math.min(min, r-j+1);
                            max = Math.max(max, r-j+1);
                            break;
                        }                        
                    }
                }
            }

            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                sb.append("-1\n");
                continue;
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }            
        }

        System.out.print(sb);
    }
}
