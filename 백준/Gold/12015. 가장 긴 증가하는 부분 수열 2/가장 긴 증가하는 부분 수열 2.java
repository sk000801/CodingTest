import java.util.*;

//어렵..다.. 이분탐색으로 부분 수열을 찾는다니
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int temp = arr[i];

            if(list.size() == 0) {
                list.add(temp);
                continue;
            }

            if(temp > list.get(list.size()-1)) {
                list.add(temp);
                continue;
            }

            int left = 0;
            int right = list.size()-1;

            while(left < right) {
                //이 쉬프트 연산자 나누기 2보다 빨라서 쓴건가
                int mid = (left+right) / 2;

                if(list.get(mid) >= temp) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            }

            //이분탐색에서 여기는 정확히 모르겠다 왜 있는지..?
            list.set(right, temp);
        }

        System.out.println(list.size()-1);
    }
}
