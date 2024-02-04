import java.util.*;
import java.io.*;

//벨트가 회전 -> 1~2n-1칸은 다음 번호의 칸으로 이동 // 2n은 1로 이동
//(0, 0) = 올리는 위치 , (0, n-1) = 내리는 위치

//1. 벨트가 각 칸 위의 로봇과 한 칸씩 회전
//2. 가장 먼저 벨트로 올라간 로봇이 벨트가 회전하는 방향으로 한 칸 갈 수 있다면
//3. 로봇 이동 -> 이동 칸 로봇 X , 내구도 >= 1
//4. 내구도 0인 칸 개수 >= k 면 과정 종료

public class Main {
    static int[] nae;
    static boolean[] robot; //존재여부

    //** 로봇이 먼저 움직여서 for문이 거꾸로 돔
    public static void action() {
        // 로봇과 컨베이어 벨트가 움직임
        int cur = nae[nae.length-1];
        for(int i = nae.length-1; i > 0; i--) {
            nae[i] = nae[i-1];
        }
        nae[0] = cur;

        for(int i = nae.length-1; i > 0; i--) {
            robot[i] = robot[i-1];
        }

        //첫번째는 회전의 시작이라, 마지막은 떨어져서 false
        robot[0] = false; 
        robot[nae.length/2-1] = false;

        //로봇 이동 (다음칸에 로봇 없고 내구성 1 이상)
        for(int i = nae.length/2-1; i > 0; i--) {
            if(robot[i-1] && !robot[i] && nae[i] >= 1) {
                robot[i] = true;
                robot[i-1] = false;
                nae[i]--;
            }
        }

        //올리는 위치가 1 이상이면 로봇 올림
        if(nae[0] > 0) {
            robot[0] = true;
            nae[0]--;
        }
    }

    public static boolean check(int k) {
        int count = 0;

        for(int i = 0; i < nae.length; i++) {
            if(nae[i] == 0) count++;
            if(count >= k) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        nae = new int[2*n];
        robot = new boolean[2*n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nae.length; i++) {
            nae[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        while(check(k)) {
            action();
            answer++;
        }

        System.out.println(answer);
    }
}
