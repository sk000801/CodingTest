import java.util.*;

// for문 돌면서 quack 찾고, 갱신하고 하려고 했는데 이게 아닌가봄
// 
public class Main {
    static String s;
    static boolean[] visited;
    static char[] ori = new char[]{'q', 'u', 'a', 'c', 'k'};
    static int answer = 0;

    public static void find(int idx) {
        int i = 0;
        boolean first = true;

        for(int j = idx; j < s.length(); j++) {
            if(s.charAt(j) == ori[i] && !visited[j]) {
                visited[j] = true;

                if(s.charAt(j) == 'k') {
                    if(first) {
                        answer++;
                        first = false;
                    }

                    i = 0;
                    continue;
                }

                i++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        s = in.nextLine();

        visited = new boolean[s.length()];

        if(s.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'q' && !visited[i]) find(i);
        }

        for(int i = 0; i < s.length(); i++) {
            if(!visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(answer == 0 ? -1 : answer);
    }
}