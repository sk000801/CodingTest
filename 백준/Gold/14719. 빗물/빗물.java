import java.util.*;

// h세로, w가로
// w개수만큼 입력 들어옴
// 어렵다
public class Main {
    static int[] height;
    static int[] res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int h = in.nextInt();
        int w = in.nextInt();
        height = new int[w+1];
        res = new int[w+1];

        for(int i = 1; i <= w; i++) {
            height[i] = in.nextInt();
            res[i] = height[i];
        }
        

        Stack<Integer> heights = new Stack<>();

        //오른쪽부터 탐색
        int temp = res[1];
        for(int i = 2; i <= w; i++) {
            //이전 위치의 값이 더 크면 stack에 넣어둠
            if(res[i] < temp) heights.add(i);
            else {
                //현재 위치의 높이가 더 크면 stack 안의 값들 갱신해줌
                //temp를 최대 높이로 설정
                while(!heights.isEmpty()) {
                    int cur = heights.pop();
                    res[cur] = temp;
                }
                temp = res[i];
            }
        }

        heights.clear();

        //왼쪽부터 탐색
        temp = res[w];
        for(int i = w-1; i >= 1; i--) {
            if(res[i] < temp) heights.add(i);
            else {
                while(!heights.isEmpty()) {
                    int cur = heights.pop();
                    res[cur] = temp;
                }
                temp = res[i];
            }
        }

        int answer = 0;
        for(int i = 1; i <= w; i++) {
            answer += res[i]-height[i];
        }

        System.out.println(answer);
    }   
}
