import java.util.*;

// 그냥 모든 수를 담아서 비교하면 안됨...?
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Queue<Long> q = new PriorityQueue<>(Collections.reverseOrder());

        int n = in.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                q.add(in.nextLong());
            }
        }

        for(int i = 0; i < n-1; i++) {
            q.poll();
        }

        System.out.println(q.peek());
    }
}
