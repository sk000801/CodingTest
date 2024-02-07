import java.util.*;
import java.io.*;

//0 = 켜짐, 1 = 꺼짐
//n개의 스위치와 n개의 전구
//i번 스위치를 누르면 i-1, i, i+1 세 개의 전구 상태가 바뀐다
//해당 상태를 만들기 위해 스위치를 최소 몇번 눌러야 하는지

//맨앞부터 상태 정하면서 답을 찾아나가야함
//근데 첫번째 스위치 누름 여부가 정해진다면 다음 스위치의 누름 여부 결정됨
//따라서 첫번째 스위치를 눌렀을 때와 누르지 않았을 때의 경우를 생각해보면 됨
public class Main {
    public static boolean check(int[] light, int[] target) {
        for(int i = 0; i < light.length; i++) {
            if(light[i] != target[i]) return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        String[] s = br.readLine().split("");
        int[] light = new int[n];
        for(int i = 0; i < n; i++) {
            light[i] = Integer.parseInt(s[i]);
        }

        s = br.readLine().split("");
        int[] target = new int[n];
        for(int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(s[i]);
        }

        int answer = 0;
        
        if(check(light, target)) {
            System.out.println(answer);
            return;
        }

        int[] temp = Arrays.copyOf(light, n);
        int value1 = 0;
        for(int i = 1; i < light.length; i++) {
            if(temp[i-1] != target[i-1]) {
                value1++;
                temp[i-1] = 1-temp[i-1];
                temp[i] = 1-temp[i];
                if(i < light.length-1) temp[i+1] = 1-temp[i+1];
            }
        }

        int[] temp2 = Arrays.copyOf(light, n);
        temp2[0] = 1-light[0];
        temp2[1] = 1-light[1];
        int value2 = 1;
        for(int i = 1; i < light.length; i++) {
            if(temp2[i-1] != target[i-1]) {
                value2++;
                temp2[i-1] = 1-temp2[i-1];
                temp2[i] = 1-temp2[i];
                if(i < light.length-1) temp2[i+1] = 1-temp2[i+1];
            }
        } 
        
        boolean res1 = check(temp, target);
        boolean res2 = check(temp2, target);

        if(!res1 && !res2) {
            answer = -1;
        } else if(res1 && res2) {
            answer = Math.min(value1, value2);
        }else if(res1) {
            answer = value1;
        } else if(res2) {
            answer = value2;
        }

        System.out.println(answer);
    }
}
