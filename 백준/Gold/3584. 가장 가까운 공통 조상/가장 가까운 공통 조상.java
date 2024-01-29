import java.util.*;

//자식들의 부모를 담아 자식과 가장 가까운 부모부터 탐색
//이렇게 풀면 list도 굳이 필요없을 것 같음
public class Main {
    static List<List<Integer>> list;
    static int[] parent;
    static boolean[] visited;

    public static int find(int n1, int n2) {
        int answer = 0;

        while(n1 > 0) {
            visited[n1] = true;
            n1 = parent[n1];
        }

        while(n2 > 0) {
            //이미 방문한 두번째 노드와 가장 가까운 부모는 바로 출력 ! (정답)
            if(visited[n2]) {
                answer = n2;
                break;
            }

            n2 = parent[n2];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();

            list = new ArrayList<>();
            parent = new int[n+1];
            visited = new boolean[n+1];
            for(int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }

            for(int j = 0; j < n-1; j++) {
                int a = in.nextInt();
                int b = in.nextInt();

                list.get(b).add(a); //부모 노드를 담는다
                parent[b] = a;
            }

            int node1 = in.nextInt();
            int node2 = in.nextInt();
            sb.append(find(node1, node2)).append("\n");
        }

        System.out.println(sb);
    }
}
