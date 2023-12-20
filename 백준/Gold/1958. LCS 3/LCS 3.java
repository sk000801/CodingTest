import java.util.*;

//lcs 규칙을 찾아서 3차원 배열에 똑같이 적용해봄...
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String s3 = in.nextLine();

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                for(int r = 1; r <= s3.length(); r++) {
                    char a = s1.charAt(i-1);
                    char b = s2.charAt(j-1);
                    char c = s3.charAt(r-1);

                    if(a == b && b == c) {
                        dp[i][j][r] = dp[i-1][j-1][r-1]+1;
                    } else {
                        dp[i][j][r] = Math.max(Math.max(dp[i-1][j][r], dp[i][j-1][r]), dp[i][j][r-1]);
                    }
                }
            }
        }

        System.out.println(dp[len1][len2][len3]);
    }
}
