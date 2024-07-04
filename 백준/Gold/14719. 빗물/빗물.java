import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int h = in.nextInt();
        int w = in.nextInt();

        int[] height = new int[w];
        int[] ans = new int[w];
        int max = 0;
        for(int i = 0; i < w; i++) {
            height[i] = in.nextInt();

            max = Math.max(height[i], max);
            ans[i] = max;
        }

        max = 0;
        for(int i = w-1; i >= 0; i--) {
            max = Math.max(height[i], max);
            // 정답은 이게 맞는데 왜 뒤에서부터 볼 때는 최솟값으로 보지?
            ans[i] = Math.min(ans[i], max);
        }

        int answer = 0;
        for(int i = 0; i < w; i++) {
            answer += ans[i]-height[i];
        }

        System.out.println(answer);
    }
}
