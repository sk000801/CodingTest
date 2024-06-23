import java.util.*;

// 자료구조를 통한 값을 갱신
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] heights = new int[1001];

        int start = Integer.MAX_VALUE;
        int fin = 0;

        for(int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            heights[x] = y;

            if(start > x) start = x;
            if(fin < x) fin = x;
        }

        Stack<Integer> stack = new Stack<>();

        int temp = heights[start];
        for(int i = start+1; i <= fin; i++) {
            if(heights[i] < temp) stack.add(i);
            else {
                while(!stack.isEmpty()) {
                    heights[stack.pop()] = temp;
                }
                temp = heights[i];
            } 
        }

        stack = new Stack<>();
        temp = heights[fin];
        for(int i = fin-1; i >= start; i--) {
            if(heights[i] < temp) stack.add(i);
            else {
                while(!stack.isEmpty()) {
                    heights[stack.pop()] = temp;
                }
                temp = heights[i];
            }
        }

        int answer = 0;
        for(int i = start; i <= fin; i++) {
            answer += heights[i];
        }

        System.out.println(answer);
    }
}
