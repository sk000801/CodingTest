import java.util.*;
import java.io.*;

//질투심이 최소
//질투심 = 가장 많은 보석을 가져간 학생이 가진 보석 개수
public class Main {
    static int n, m;
    static int[] dia;

    public static int check(int num) {
        int result = 0;

        for(int i = 0; i < m; i++) {
            if(dia[i] % num == 0) {
                result += dia[i]/num; 
            } else {
                result += dia[i]/num+1;
            }
        }

        return result;
    }
    public static int action(int start, int fin) {
        while(start <= fin) {
            int mid = (start+fin)/2;

            int result = check(mid);

            if(result > n) {
                start = mid+1;
            } else {
                fin = mid-1;
            }
        }

        return start;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        dia = new int[m];

        for(int i = 0; i < m; i++) {
            dia[i] = in.nextInt();
        }
        Arrays.sort(dia);

        System.out.println(action(1, dia[m-1]));
    }
}
