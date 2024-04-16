import java.util.*;

// 세준이는 0에 위치하고, 사람들이 반납한 책들도 모두 0에 있음
// 각 책들의 원래 위치가 주어질 때, 책을 제자리에 놔둘 때 드는 최소 걸음 수 계산
// 한 걸음에 좌표 한칸

// 거리가 멀리있는 m권의 책을 들고 먼저 이동
// 그리고 음수, 양수 위치의 책을 따로 구분해 책을 하나 옮긴 뒤 0에 들러 
// 책을 하나 더 챙겨 이동하면 됨
// 따라서 우선순위 큐 두 개로 정렬해보자

// 가장 멀리에 있는 위치*2를 이동거리라고 치고, m권의 책 poll

// ** 모든 책을 가져다놓으면 0으로 다시 이동할 이유가 없으므로 최댓값 빼주기
public class Main {
    static int n, m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        // 둘 모두 내림차순으로 정렬
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b-a);

        int farPos = 0;
        for(int i = 0; i < n; i++) {
            int pos = in.nextInt();

            if(pos < 0) pq2.add(Math.abs(pos));
            else pq1.add(pos);

            farPos = Math.max(farPos, Math.abs(pos));
        }

        int answer = 0;

        while(!pq1.isEmpty()) {
            int cur = pq1.poll();

            for(int i = 0; i < m-1; i++) {
                pq1.poll();

                if(pq1.isEmpty()) break;
            }

            answer += cur*2;
        }

        while(!pq2.isEmpty()) {
            int cur = pq2.poll();

            for(int i = 0; i < m-1; i++) {
                pq2.poll();

                if(pq2.isEmpty()) break;
            }

            answer += cur*2;
        }

        answer -= farPos;

        System.out.println(answer);
    }
}
