import java.util.*;

// 각각의 고리는 최대 두 개의 인접한 고리를 가질 수 있음
// 체인을 분리하거나 두 체인을 연결해 하나의 긴 체인으로
// 가능한 한 적은 고리를 열고 닫아 모든 체인을 하나의 긴 체인으로 만들기
// 가장 짧은 체인으로 고리를 만들어 가장 긴 체인부터 연결해 체인의 개수가 1이 될 때까지 반복
// 입력받은 체인의 길이를 오름차순으로 정렬한 뒤 체인 길이를 줄여가며 연결

// 왜 덱으로 접근하면 값이 하나 더 나올까...
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        Collections.sort(list);

        // Deque<Integer> d = new ArrayDeque<>(list);

        int count = 0;
        // while (true) {             
        //     if(d.size() <= 2) break;

        //     int firstNum = d.pollFirst();
        //     if(firstNum > 0) d.addFirst(firstNum-1);

        //     d.pollLast();

        //     count++;
        // }

        while(true) {
            if(list.size() <= 1) break;

            list.set(0, list.get(0)-1);

            list.remove(list.size()-1);

            if(list.get(0) == 0) list.remove(0);

            count++;
        } 

        System.out.println(count);
    }
}
