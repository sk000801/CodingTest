import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int r = in.nextInt();

        String s1 = Integer.toString(l);
        String s2 = Integer.toString(r);

        int answer = 0;
        if(s1.length() == s2.length()) {
            for(int i = 0; i < s1.length(); i++) {
                char a = s1.charAt(i);
                char b = s2.charAt(i);

                if(a == b) {
                    if(a == '8') answer++;
                } else { //다른 수가 생기는 순간부터 8은 등장할 수 없음
                    break;
                }            
            }
        }

        System.out.println(answer);
    }
}
