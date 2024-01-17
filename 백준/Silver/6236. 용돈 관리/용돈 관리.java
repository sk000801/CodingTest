import java.util.*;

// n일동안 사용할 금액
// m번만 통장에서 빼낼 수 있도록
// k원 인출하고 모자라면 남은 금액 넣고 다시 k원 인출

public class Main {
    static int n, m;
    static int[] price;

    public static int cal(int k) {
        int count = 1;
        int temp = k;

        for(int i = 0; i < n; i++) {
           temp -= price[i];

           if(temp < 0) {
            temp = k-price[i];
            count++;
           }
        }

        return count;
    }

    public static int action(int start, int fin) {
        int mid = 0;

        while(start <= fin) {
            mid = (start+fin)/2;

            if(cal(mid) <= m) {
                fin = mid-1;
            } else {
                start = mid+1;
            }            
        }

        return mid;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        price = new int[n];

        int fin = 0;
        //근데 왜 시작값이 배열의 최대일까?
        //그게 아니라면 문제가 성립할 수 없어서 그런가?
        int start = 0;

        for(int i = 0; i < n; i++) {
            price[i] = in.nextInt();
            fin += price[i];
            start = Math.max(price[i], start);
        }

        System.out.println(action(start, fin));
    }
}
