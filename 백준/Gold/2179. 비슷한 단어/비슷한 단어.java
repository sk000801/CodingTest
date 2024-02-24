import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

       String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int max = 0;
        int[] ans = new int[2];
        for(int i = 0; i < n-1; i++) {
            String s1 = words[i];
            for(int j = i+1; j < n; j++) {
                String s2 = words[j];

                int count = 0;

                //이거 근데 왜 != 로 둘 때는 잘 안되남 ㅠㅠ
                for(int r = 0; r < Math.min(s1.length(), s2.length()); r++) {
                    if(s1.charAt(r) != s2.charAt(r)) {
                        break;
                    }
                    count++;
                }

                if(max < count) {
                    max = count;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        System.out.println(words[ans[0]]);
        System.out.print(words[ans[1]]);
    }
}
