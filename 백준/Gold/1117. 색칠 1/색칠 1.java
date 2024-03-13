import java.util.*;
import java.io.*;

// 종이를 x=f에 맞춰서 접는다.
// 가로로 c+1개의 크기가 동일한 구간으로 나눈다. c번 가장 위의 구간부터 접는다.
// f가 w/2보다 크거나 작을 때의 경우를 기준으로 계산
// 풀이 참고

public class Main {
    static long w,h,f,c,x1,y1,x2,y2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Long.parseLong(st.nextToken());
        h = Long.parseLong(st.nextToken());
        f = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());

        long entireArea = w*h;

        long x = 0;
        if(f <= w/2) {
            x = f;
        } else {
            x = w-f;
        }

        if(x <= x1) {
            entireArea -= (c+1)*(y2-y1)*(x2-x1);
            //System.out.println("x<=x1 "+entireArea);
        } else if(x < x2) {
            entireArea -= 2*(c+1)*(y2-y1)*(x-x1); 
            entireArea -= (c+1)*(y2-y1)*(x2-x); 
            //System.out.println("x<x2 "+entireArea);
        } else {
            entireArea -= 2*(c+1)*(y2-y1)*(x2-x1);
        }

        System.out.println(entireArea);
    }
}
