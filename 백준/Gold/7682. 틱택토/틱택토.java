import java.util.*;
import java.io.*;

// 틱택토는 가로/세로/대각선으로 3칸을 잇는데 성공하면 즉시 끝!

// 승자 정해진 여부 or O와 X의 개수
// O와 X의 개수가 같을 때는 승자가 정해지지 않았을 때
// X의 개수가 많을 때는 9개 꽉 채웠거나 이겼을 때
public class Main {
    public static boolean check(char[][] arr, char c) {
        for(int i = 0; i < 3; i++) { //열 
            boolean flag = true;
            for(int j = 0; j < 3; j++) {
                if(arr[i][j] != c) flag = false;
            }
            if(flag) return true;
        }
        
        for(int i = 0; i < 3; i++) { //행
            boolean flag = true;
            for(int j = 0; j < 3; j++) {
                if(arr[j][i] != c) flag = false;
            }
            if(flag) return true;
        }
        
        if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) return true;
        if(arr[0][2] == c && arr[1][1] == c && arr[2][0] == c) return true;
        
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringBuffer sb = new StringBuffer();

        while(!(s = br.readLine()).equals("end")) {
            int countO = 0;
            int countX = 0;

            char[][] arr = new char[3][3];
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    arr[i][j] = s.charAt(3*i+j);
                    if(arr[i][j] == 'O') countO++;
                    if(arr[i][j] == 'X') countX++;
                }
            }

            int diff = countX-countO;
            if(diff == 0 || diff == 1) {
                if(countX >= 3) {
                    if(check(arr, 'X')) {
                        if(check(arr, 'O')) sb.append("invalid\n");
                        else if(diff == 1) sb.append("valid\n");
                        else sb.append("invalid").append("\n");       
                        
                        continue;
                    }
                }
                if(countO >= 3) {
                    if(check(arr, 'O')) {
                        if(diff == 0) sb.append("valid").append("\n");
                        else sb.append("invalid").append("\n");

                        continue;
                    }
                }
                if(countX+countO < 9) {
                    sb.append("invalid\n");
                    continue;
                }
            } else {
                sb.append("invalid\n");
                continue;
            }

            sb.append("valid\n");
        }

        System.out.println(sb);
    }
}
