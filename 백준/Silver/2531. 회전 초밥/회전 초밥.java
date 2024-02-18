import java.util.*;
import java.io.*;

//회전초밥 골라먹기

// 벨트의 임의의 한 위치 ~ k개 연속해서 먹으면 할인된 가격 제공
// 초밥의 종류 쿠폰 발행 -> 위 행사 참여하면 초밥 하나 무료 제공
// 왜 방문 배열이 int인가 했더니 겹칠수도 있어서인듯 (여러개면 하나 빠져도 상관없으니까)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //접시수
        int d = Integer.parseInt(st.nextToken()); //초밥 종류
        int k = Integer.parseInt(st.nextToken()); //연속접시수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        int[] sushi = new int[n];
        int[] visited = new int[d+1];
        for(int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        //초기값 설정
        for(int i = 0; i < k; i++) {
            if(visited[sushi[i]] == 0) count++;
            visited[sushi[i]]++;
        }
        int max = count;

        //이후 다음 컨테이너 값을 넣었다 빼며 결과값 비교
        for(int i = 1; i <= n; i++) {
            if(max <= count) {
                if(visited[c] == 0) max = count+1;
                else max = count;
            }

            //이전 컨테이너 방문 값을 빼줌
            visited[sushi[i-1]]--;
            if(visited[sushi[i-1]] == 0) count--;

            //마지막 컨테이너 방문 값을 더해줌
            if(visited[sushi[(i+k-1)%n]] == 0) count++;
            visited[sushi[(i+k-1)%n]]++;
        }

        System.out.println(max);
    }
}
