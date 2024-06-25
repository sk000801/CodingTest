import java.util.*;

// 경우의 수를 나눠야 함
// 1. R이 왼쪽으로 쏠림
// 2. R이 오른쪽으로 쏠림
// 3. B가 왼쪽으로 쏠림
// 4. B가 오른쪽으로 쏠림
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] ball = in.nextLine().split("");

        int answer = Integer.MAX_VALUE;

        int red = 0;
        int blue = 0;
        int first = 0;

        for(String s : ball) {
            if(s.equals("R")) red++;
            else blue++;
        }

        for(String s : ball) {
            if(s.equals("R")) first++;
            else break;
        }

        answer = Math.min(answer, red-first);

        first = 0;
        for(int i = n-1; i >= 0; i--) {
            if(ball[i].equals("R")) first++;
            else break;
        }

        answer = Math.min(answer, red-first);

        first = 0;
        for(String s : ball) {
            if(s.equals("B")) first++;
            else break;
        }

        answer = Math.min(answer, blue-first);

        first = 0;
        for(int i = n-1; i >= 0; i--) {
            if(ball[i].equals("B")) first++;
            else break;
        }

        answer = Math.min(answer, blue-first);

        System.out.println(answer);
    }
}
