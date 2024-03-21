import java.util.*;
import java.io.*;

// 건물 N개가 존재함
// 현재 건물 높이가 L이면 높이가 L보다 큰 곳의 건물만 볼 수 있음
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] building = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        int[] nearBuilding = new int[n];
        int[] num = new int[n];
        Arrays.fill(nearBuilding, -100_000);

        //왼쪽->오른쪽
        for(int i = 0; i < n; i++) {
            //해당 빌딩보다 높이가 작으면 안보임
            while(!stack.isEmpty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }

            num[i] += stack.size();
            if(num[i] > 0) nearBuilding[i] = stack.peek();
            stack.add(i);
        }

        //오른쪽->왼쪽
        stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }

            num[i] += stack.size();
            //해당 빌딩 오른쪽과의 거리가 더 가깝다면 배열값 갱신
            if(stack.size() > 0 && stack.peek()-i < i-nearBuilding[i]) nearBuilding[i] = stack.peek();
            stack.add(i);            
        }

        for(int i = 0; i < n; i++) {
            System.out.print(num[i]);
            if(num[i] > 0) {
                System.out.print(" "+(nearBuilding[i]+1));
            }
            System.out.println();
        }
    }
}
