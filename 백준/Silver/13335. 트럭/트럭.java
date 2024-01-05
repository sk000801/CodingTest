import java.util.*;

//정답: 최단시간
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); //트럭개수
        int w = in.nextInt(); //다리길이
        int l = in.nextInt(); //최대하중
        int[] truck = new int[n];
        
        for(int i = 0; i < n; i++) {
            truck[i] = in.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < w; i++) {
            q.add(0);
        }

        int answer = 0;
        int idx = 0;
        int weight = 0;
        while(!q.isEmpty()) {
            answer++;
            weight -= q.poll();

            if(idx >= truck.length) continue;

            if(weight+truck[idx] <= l) {
                weight += truck[idx];
                q.add(truck[idx]);
                idx++;
            } else {
                q.add(0); //다리 건너는 시간 or 공백
            }
        }

        System.out.println(answer);
    }
}
