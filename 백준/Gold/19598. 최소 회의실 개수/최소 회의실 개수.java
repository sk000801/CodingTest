import java.util.*;
import java.io.*;

public class Main {
    public static class Meeting implements Comparable<Meeting> {
        int time;
        boolean start;

        public Meeting(int time, boolean start) {
            this.time = time;
            this.start = start;
        }

        @Override
        public int compareTo(Meeting m) {
            return this.time-m.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new Meeting(a, true));
            pq.add(new Meeting(b, false));
        }

        int count = 0;
        int answer = 0;
        // 시작, 끝 시간을 모두 넣어
        // 시작 시간이면 회의실을 새로 추가하고, 회의가 끝나면 회의실 없앰
        // 생긴 회의실이 가장 많은 경우가 최소이므로 count의 최댓값이 정답
        while(!pq.isEmpty()) {
            Meeting cur = pq.poll();

            if(cur.start) {
                count++;
                answer = Math.max(count, answer);
            } else count--;
        }

        System.out.println(answer);
    }
}
