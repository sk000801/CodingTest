import java.util.*;

//set을 활용해 변형된 s의 문자열들을 담아주려고 하였으나 -> 시간초과,,,
//t의 문자열을 하나씩 빼주면서 확인함... dfs의 방식으로?
public class Main {
    public static int find(String t, String s) {
        if(t.length() == s.length()) {
            if(t.equals(s)) return 1;

            return 0;
        }

        int answer = 0;

        if(t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            answer += find(sb.reverse().toString(), s);
        }

        if(t.charAt(t.length()-1) == 'A') {
            answer += find(t.substring(0, t.length()-1), s);
        }

        return answer > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String t = in.nextLine();

        System.out.println(find(t, s));
    }   
}
