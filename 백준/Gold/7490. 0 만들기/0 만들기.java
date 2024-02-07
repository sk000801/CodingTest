import java.util.*;

//1~n까지의 수 사이의 +, -, "" (이어붙이기)로 결과가 0이 되게 만들기
public class Main {
    static String[] hubo = {"","+","-"};
    static StringBuffer sb = new StringBuffer();

    public static int calculate(String[] cur, int n) {
        String s = "";
        for(int i = 0; i < n-1; i++) {
            s += (i+1)+cur[i];
        }
        s += n;

        String[] num = s.replace("+", " ").replace("-", " ").split(" ");

        int res = Integer.parseInt(num[0]);
        int idx = 1;
        for(int i = 0; i < cur.length; i++) {
            if(cur[i].equals("+")) {
                res += Integer.parseInt(num[idx++]);
            } 
            if(cur[i].equals("-")) {
                res -= Integer.parseInt(num[idx++]);
            }
        }

        return res;
    }

    public static void dfs(int depth, int n, String[] cur) {
        if(depth == n-1) {
            int num = calculate(cur, n);
            if(num == 0) {
                for(int i = 0; i < n-1; i++) {
                    if(cur[i].equals("")) sb.append((i+1)+" ");
                    else sb.append((i+1)+cur[i]);
                }
                sb.append(n);
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < 3; i++) {
            cur[depth] = hubo[i];
            dfs(depth+1, n, cur);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tc = in.nextInt();
        for(int i = 0; i < tc; i++) {
            int n = in.nextInt();
            
            String[] cur = new String[n-1];
            dfs(0, n, cur);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
