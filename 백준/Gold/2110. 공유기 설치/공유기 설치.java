import java.util.*;
import java.io.*;

public class Main {
    static int n, c;
    static int[] house;
    public static int check(int distance) {
        int count = 1;

        int temp = house[0];
        for(int i = 1; i < n; i++) {
            if(temp+distance <= house[i]) {
                count++;
                temp = house[i];
            }
        }

        return count;
    }
    public static int search(int start, int fin) {
        while(start < fin) {
            int mid = (start+fin)/2;

            if(check(mid) < c) {
                fin = mid;
            } else {
                start = mid+1;
            }
        }

        //반환값이 start < fin 조건을 초과하는 값이므로 1을 빼야함
        return start-1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        house = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);

        //집 사이의 거리를 이분탐색의 단위로
        System.out.println(search(1, house[n-1]-house[0]+1));
    }
}
