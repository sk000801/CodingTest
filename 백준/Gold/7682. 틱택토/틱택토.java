import java.util.*;

// X와 O 순서가 번갈아 (놓여있는 개수가 X가 O 이상이어야 함)
// 가로, 세로, 대각선 방향으로 3칸을 잇는데 성공하면 게임 끝!
// 그냥 노가다로 풀어봐도 괜찮을 것 같은데,,,
// 왜 안될까.. 모르겠음
// X와 O 경우가 모두 정답을 만족할 때 for문의 순서에 따라 결과가 바뀔수도 있어서 10%에서 걸리는 것 같다
// 경우의 수를 나눈 다음에 판별해야할듯,,
public class Main {
    public static boolean check(char[][] ex, char c) {
        for(int i = 0; i < 3; i++) {
            if(ex[0][i] == ex[1][i] && ex[1][i] == ex[2][i]) {
                if(ex[0][i] == c) return true;
            }

            if(ex[i][0] == ex[i][1] && ex[i][1] == ex[i][2]) {
                if(ex[i][0] == c) return true;
            }
        }

        if(ex[0][0] == c && ex[1][1] == c && ex[2][2] == c) return true;
        if(ex[0][2] == c && ex[1][1] == c && ex[2][0] == c) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();

        while(true) {
            String s = in.nextLine();

            if(s.equals("end")) break;

            char[][] ex = new char[3][3];
            for(int i = 0; i < s.length(); i++) {
                ex[i/3][i%3] = s.charAt(i);
            }

            int xCount = 0;
            int oCount = 0;

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(ex[i][j] == 'X') xCount++;
                    if(ex[i][j] == 'O') oCount++;
                }
            }

            if(!(xCount == oCount || xCount - oCount == 1)) {
                sb.append("invalid\n");
                continue;
            }

            if(xCount+oCount == 9 && xCount-oCount == 1) {
                if(!check(ex, 'O')) {
                    sb.append("valid\n");
                    continue;
                }
            } else {
                if(check(ex, 'X') && xCount-oCount == 1) {
                    if(!check(ex, 'O')) {
                        sb.append("valid\n");
                        continue;
                    }
                }

                if(check(ex, 'O') && xCount == oCount) {
                    sb.append("valid\n");
                    continue;
                }
            }

            sb.append("invalid\n");
        }

        System.out.println(sb);
    }
}
