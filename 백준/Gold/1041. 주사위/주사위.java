import java.util.*;

//dice[0]-dice[5] , dice[1]-dice[4] , dice[2]-dice[3]
// n > 1일 때는
// 3개의 면이 보이는 주사위 수 : 4개
// 2개의 면이 보이는 주사위 수 : 8n-12개
// 1개 면 보이는 주사위 수 : 5n^2-16n+12개
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();
        long[] dice = new long[6];
        long sum = 0; long max = 0;
        for(int i = 0; i < 6; i++) {
            dice[i] = in.nextLong();
            max = Math.max(max, dice[i]);
            sum += dice[i];
        }

        long l = Long.MAX_VALUE;
        long l2 = Long.MAX_VALUE;
        long l3 = Long.MAX_VALUE;

        for(int i = 0; i < 6; i++) {
            l = Math.min(l, dice[i]);
            for(int j = i+1; j < 6; j++) {
               if(i+j == 5) continue;

                l2 = Math.min(l2, dice[i]+dice[j]);
                for(int r = j+1; r < 6; r++) {
                    if(i+r == 5 || j+r == 5) continue;
                    
                    l3 = Math.min(l3, dice[i]+dice[j]+dice[r]);
                }
            }
        }

        if(N == 1) {
            System.out.println(sum-max);
            return;
        }

        long val = (4*l3)+(8*N-12)*l2+(5*N*N-16*N+12)*l;
        System.out.println(val);
    }
}
