import java.io.*;

// 비슷한 단어 = 하나의 문자 차이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String standard = br.readLine();

        int answer = 0;

        for(int i = 0; i < n-1; i++) {
            String s = br.readLine();

            int count = 0;

            int[] alpha = new int[26];

            for(int j = 0; j < standard.length(); j++) {
                alpha[standard.charAt(j)-'A']++;
            }

            for(int j = 0; j < s.length(); j++) {
                if(alpha[s.charAt(j)-'A'] > 0) {
                    // 같은 단어 개수
                    count++;
                    alpha[s.charAt(j)-'A']--;
                }
            }

            // 같거나 한글자만 바뀜
            if(standard.length() == s.length() && (standard.length() == count || standard.length()-1 == count)) {
                answer++;
            
                //비교할 문자열이 짧을 때
            } else if(standard.length() == s.length()-1 && s.length()-1 == count) {
                answer++;
                // 비교할 문자열이 길 때
            } else if(standard.length() == s.length()+1 && s.length() == count) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
