import java.util.*;

//최소힙
//배열에 자연수 x를 넣음 -> 배열에서 가장 작은 값 출력 -> 배열에서 제거
//x가 자연수라면 배열에 x라는 값을 추가
//x가 0 -> 배열에서 가장 작은 값 출력, 배열에서 제거
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuffer sb = new StringBuffer();

        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int num = in.nextInt();

            if(num == 0) {
                if(pq.size() == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }   
            } else {
                pq.add(num);
            }
        }

        System.out.println(sb);
    }
}
