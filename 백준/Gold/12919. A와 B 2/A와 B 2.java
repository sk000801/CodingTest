import java.util.*;

public class Main {
    static boolean isAble = false;
    public static void check(String s, String t) {
        if(s.equals(t)) {
            isAble = true;
            return;
        }

        if(s.length() > t.length()) return;

        if(t.charAt(t.length()-1) == 'A') check(s, t.substring(0, t.length()-1));
        if(t.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer(t.substring(1, t.length()));
            check(s, sb.reverse().toString());
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String t = in.nextLine();

        check(s, t);

        System.out.println(isAble ? 1 : 0);
    }
}
