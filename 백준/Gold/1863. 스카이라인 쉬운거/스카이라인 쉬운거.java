import java.io.*;
import java.util.*;

// 입력 -> 스카이라인의 고도가 바뀌는 지점(x, y)
// 건물의 높이가 달라지는 지점 체크
// -> 높이가 같다면 같은 건물로 취급하고 continue
// -> 입력값이 더 크다면 뒤의 빌딩과 이어지는 새로운 건물일수도
// -> 입력값이 더 작다면 이전의 빌딩들이 하나의 건물임이 입증
// 풀이 보고 30분 절대 안쉬운데요..? 높이만 보고 비교하는 줄 몰랐음
public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] lines = new int[n+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i] = b;
        }

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() > lines[i]) {
                answer++;
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() == lines[i]) continue;

            stack.push(lines[i]);
        }

        while(!stack.isEmpty()) {
            if(stack.pop() > 0) answer++;
        }

        System.out.println(answer);
    }
}
