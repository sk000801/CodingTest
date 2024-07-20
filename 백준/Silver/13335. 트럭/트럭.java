import java.util.*;

// 동시에 w대의 트럭만
// 무게 l 초과하면 안됨
// q에 미리 w대만 넣어놓고 빼고 넣으면서 합 비교
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int w = in.nextInt();
        int l = in.nextInt();

        int[] weight = new int[n];

        for(int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < w; i++) {
            q.add(0);
        }

        int answer = 0;
        int idx = 0;
        int hap = 0;
        while(!q.isEmpty()) {
            answer++;
            hap -= q.poll();

            if(idx < n) {
                if(weight[idx]+hap <= l) {
                    hap += weight[idx];
                    q.add(weight[idx++]);
                } else q.add(0);
            }
        }

        System.out.println(answer);
    }
}
