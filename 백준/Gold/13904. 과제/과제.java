import java.util.*;

// pq와 class를 사용해보려 했으나,, fail ,,, 
public class Main {
    public class Homework {
        int day, score;
        public Homework(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        // 제한날짜, 점수
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new int[]{in.nextInt(), in.nextInt()});
        }

        //날짜 따라 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] arr : list) {
            pq.add(arr[1]);

            //다음에 풀 수 있는 문제가 현재 마감일을 초과할 경우
            if(pq.size() > arr[0]) {
                pq.poll();
            }
        }

        int answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
