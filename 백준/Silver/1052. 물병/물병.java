import java.util.*;

// 물병 하나에 물이 1리터씩 들어있음
// 비어있지 않은 물병이 K개 이하
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int answer = 0;

        if(n <= m) {
            System.out.println(0);
            return;
        }

        while(true) {
            char[] arr = Integer.toBinaryString(n).toCharArray();

            int count = 0;

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] =='1') count++;
            }

            if(count <= m) {
                System.out.println(answer);
                return;
            }

            n++;
            answer++;
        }
    }
}
