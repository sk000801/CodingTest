import java.io.*;
import java.util.*;

// 지표면에 떨어지는 별똥별의 수 최소화
// 커다란 네모난 L*L 크기의 트램펄린 준비

// Q. 지구에는 몇 개의 별똥별의 부딪히게 될까?

// 가로, 세로의 범위가 넓으므로 별똥별(100개 이하)을 활용해 답을 구해보자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken()); //트램펄린 한변
        int k = Integer.parseInt(st.nextToken()); //별똥별 수

        List<int[]> list = new ArrayList<>(); //별똥별 저장
        
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y});
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++) {
                int[] star1 = list.get(i);
                int[] star2 = list.get(j);

                int ans = 0;
                for(int r = 0; r < list.size(); r++) {
                    int[] cur = list.get(r);
                    if(star1[0] <= cur[0] && star2[1] <= cur[1] && cur[0] <= star1[0]+l && cur[1] <= star2[1]+l) ans++;
                }
                max = Math.max(ans, max);
            }
        }

        System.out.println(k-max);
    }
}
