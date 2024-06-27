import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] power;
    static boolean[] robot;

    public static boolean isAble() {
        int count = 0;

        for(int i = 0; i < 2*n; i++) {
            if(power[i] == 0) count++;
        }

        if(count >= k) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        power = new int[2*n];
        robot = new boolean[2*n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*n; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while(isAble()) {
            int temp = power[2*n-1];

            for(int i = 2*n-1; i > 0; i--) {
                power[i] = power[i-1];
            }
            power[0] = temp;
            
            for(int i = 2*n-1; i > 0; i--) {
                robot[i] = robot[i-1];
            }
    
            robot[0] = false;
            robot[n-1] = false;

            for(int i = n-1; i > 0; i--) {
                if(robot[i-1] && !robot[i] && power[i] > 0) {
                    power[i]--;
                    robot[i] = true;
                    robot[i-1] = false;
                }
            }
    
            if(power[0] > 0) {
                robot[0] = true;
                power[0]--;
            }

            count++;
        }

        System.out.println(count);
    }
}
