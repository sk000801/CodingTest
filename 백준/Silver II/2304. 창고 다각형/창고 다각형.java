import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] height = new int[1001];
        int max = 0;
        int start = 0;
        int fin = 0;
        for(int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            max = Math.max(max, y);
            start = Math.min(start, x);
            fin =  Math.max(fin, x);
            height[x] = y;
        }

        Stack<Integer> stack = new Stack<>();

        //현재 최댓값보다 작으면 현재 최댓값이 높이가 되고
        //커지면 최댓값을 갱신하고 이전 값들을 이전 최댓값으로 갱신
        int temp = height[start];
        for(int i = start+1; i <= fin; i++) {
            if(height[i] < temp) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    int x = stack.pop();
                    height[x] = temp;
                }
                temp = height[i];
            }
        }

        stack = new Stack<>();
        temp = height[fin];
        for(int i = fin-1; i >= start; i--) {
            if(height[i] < temp) stack.push(i);
            else {
                while(!stack.isEmpty()) {
                    int x = stack.pop();
                    height[x] = temp;
                }
                temp = height[i];
            }
        }

        int answer = 0;
        for(int i = start; i <= fin; i++) {
            answer += height[i];
        }

        System.out.println(answer);
    }
}
