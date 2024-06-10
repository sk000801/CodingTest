import java.io.*;
import java.util.*;

public class Main {

    private static class Lecture implements Comparable<Lecture> {
        int num, start, end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture l) {
            return this.start-l.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Lecture> list = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int lecNum = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int fin = Integer.parseInt(st.nextToken());

            list.add(new Lecture(lecNum, start, fin));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek() <= list.get(i).start) {
                // 큐에 강의가 들어있고 다음 강의 시작 시간이 현재 강의 시간과 겹치지 않는다면
                pq.poll();
            }

            // 다음 강의 시간을 우선순위 큐에 넣음
            pq.add(list.get(i).end);

            // 우선순위 큐에 남아있는 강의들은 각자 다른 강의실에서 수업이 진행됨
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }   
}


