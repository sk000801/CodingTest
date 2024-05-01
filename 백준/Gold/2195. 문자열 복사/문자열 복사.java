import java.util.*;

// 이걸 풀이처럼 풀어보라고 하면 바로 떠올리진 못할듯
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String p = in.nextLine();

        int answer = 0;

        int idx = 0;

        for(int i = 0; i < p.length(); i++) {
            if(s.indexOf(p.substring(idx, i+1)) != -1) continue;
            answer++;
            idx = i;
        }

        System.out.println(answer+1);
    }
}
