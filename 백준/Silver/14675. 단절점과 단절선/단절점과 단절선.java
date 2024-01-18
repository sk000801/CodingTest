import java.util.*;

// t가 1이라면 루트 or 리프 정점 삭제한 경우 or not
// t가 2라면 어떤 간선을 제거했을 때 무조건 두 갈래로 나뉨
public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= n-1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        int tc = in.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < tc; i++) {
            int t = in.nextInt();
            int k = in.nextInt();

            if(t == 2) {
                sb.append("yes\n");
            } else if(t ==1) {
                int count = list.get(k).size();
                if(count >= 2) sb.append("yes\n");
                else sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}
