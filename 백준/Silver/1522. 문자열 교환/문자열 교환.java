import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int min = Integer.MAX_VALUE;
        int len = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') len++;
        }

        for(int i = 0; i < s.length(); i++) {
            int count = 0;
            for(int j = i; j < i+len; j++) {
                if(s.charAt(j%s.length()) == 'b') count++;
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}
