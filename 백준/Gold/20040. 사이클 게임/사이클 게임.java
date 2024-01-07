import java.util.*;

public class Main {
    static int[] parents;
    static int n, m;

    public static int find(int n) {
        if(n == parents[n]) return n;
        parents[n] = find(parents[n]);

        return parents[n];
    }

    public static boolean union(int n1, int n2) {
        int r1 = find(n1);
        int r2 = find(n2);

        if(r1 == r2) return false;

        parents[r1] = r2;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        parents = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            
            //부모가 같다면 이미 사이클 형성됨
            if(!union(node1, node2)) {
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(0);
    }
}
