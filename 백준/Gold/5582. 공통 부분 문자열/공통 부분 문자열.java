import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();
    
        int[][] value = new int[s1.length()][s2.length()];
        int max = 0;

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i == 0 || j == 0) {
                        value[i][j] = 1;
                    } else {
                        value[i][j] = value[i-1][j-1]+1;
                    }
                }

                max = Math.max(value[i][j], max);
            }
        }

        System.out.println(max);
    }
}
