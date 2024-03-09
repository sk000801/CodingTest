import java.util.*;
import java.io.*;

// 전파의 기본 단위 {0, 1}
// x+()는 임의의 개수 (최소 1개) x의 반복으로 이뤄진 전파의 집합
// (100+1+|01)+ 의 패턴을 가진 전파를 가려내는 프로그램 찾기
// +는 반복 |는 or


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            if(s.matches("(100+1+|01)+")) sb.append("YES");
            else sb.append("NO");

            if(i < t-1) sb.append("\n");
        }

        System.out.println(sb);
    }
}
