import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int num = Math.abs(a)-Math.abs(b);
                if(num == 0) return a-b;
                else return num;
            }
    });

        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int num = in.nextInt();
            if(num != 0) {
                pq.add(num);
            } else {
                if(pq.size() == 0) {
                    sb.append("0\n");
                    continue;
                }
                sb.append(pq.peek()).append("\n");
                pq.poll();
            }
        }

        System.out.println(sb);
    }
}
