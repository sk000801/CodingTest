import java.util.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static int[] parent;

    public static int find(int node) {
        if(node == parent[node]) return node;

        parent[node] = find(parent[node]);

        return parent[node];
    }

    public static boolean union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) {
            parent[root2] = root1;
            parent[root1] = 0; //부모 노드가 0을 가리키도록 함
            return false;
        } 
 
        int max = Math.max(root1, root2);
        int min = Math.min(root1, root2);

        parent[max] = min;

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();

        int caseNum = 0;
        while(true) {
            int n = in.nextInt();
            int m = in.nextInt();   

            caseNum++;
            
            if(n == 0 && m == 0) break;
            
            parent = new int[n+1];
            set = new HashSet<>();
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for(int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();

                union(a, b);
            } 

            for(int i = 1; i <= n; i++) {
                int parentNode = find(i);

                if(parentNode > 0) {
                    set.add(parentNode);
                }
            }

            int answer = set.size();
            sb.append("Case "+caseNum+": ");
            if(answer== 0) {
                sb.append("No trees.\n");
            } else if(answer == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of "+answer+" trees.\n");
            }
        }

        System.out.println(sb);
    }
}
