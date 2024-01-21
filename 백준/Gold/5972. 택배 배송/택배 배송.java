import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int pos, val;
        public Node(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
        @Override
        public int compareTo(Node n) {
            return this.val-n.val;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Node>> list = new ArrayList<>();
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        Arrays.fill(dist,5000_0001);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.pos]) continue;
            visited[cur.pos] = true;

            for(int i = 0; i < list.get(cur.pos).size(); i++) {
                Node next = list.get(cur.pos).get(i);

                if(dist[next.pos] > dist[cur.pos] + next.val) {
                    dist[next.pos] = dist[cur.pos]+next.val;
                    pq.add(new Node(next.pos, dist[next.pos]));
                }
            }
        }

        System.out.println(dist[n]);
    }
}
