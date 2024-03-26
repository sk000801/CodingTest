import java.util.*;

// 풀이를 보면서 겨우 이해함 ㅠㅠ
// 맵을 어떻게 관리하느냐가 문제 풀이의 관건인듯
public class Main {
    static int[] num = new int[11];
    static int[] permNum = new int[11];
    static Point[] map = new Point[32];
    static Horse[] horse = new Horse[5];
    static boolean[] visited = new boolean[32];
    static int answer = 0;
    static int temp_answer = 0;

    public static class Horse {
        int idx;
        boolean blueflag;

        public Horse(int idx, boolean blueflag) {
            this.idx = idx;
            this.blueflag = blueflag;
        }
    }

    public static class Point {
        int red; //빨간 길의 다음 인덱스
        int blue; //파란 길의 다음 인덱스
        int now; //해당 인덱스의 값

        public Point(int red, int blue, int now) {
            this.red = red;
            this.blue = blue;
            this.now = now;
        }
    }

    public static void setting() {
        map[0] = new Point(1, 0, 0);

        int curNum = 2;
        // 빨간색으로 둘러싸는 테두리
        for(int i = 1; i <= 19; i++) {
            map[i] = new Point(i+1, 0, curNum);
            curNum += 2;
        }

        map[20] = new Point(100, 0, 40);

        // 파란색 지름길로 가는 부분
        map[5].blue = 21;
        map[10].blue = 29;
        map[15].blue = 27;

        map[21] = new Point(22, 0, 13);
        map[22] = new Point(23, 0, 16);
        map[23] = new Point(24, 0, 19);
        map[24] = new Point(30, 0, 25);
        map[25] = new Point(24, 0, 26);
        map[26] = new Point(25, 0, 27);
        map[27] = new Point(26, 0, 28);
        map[28] = new Point(24, 0, 24);
        map[29] = new Point(28, 0, 22);
        map[30] = new Point(31, 0, 30);
        map[31] = new Point(20, 0, 35);

        for(int i = 1; i <= 4; i++) {
            horse[i] = new Horse(0, false);
        }
    }

    public static void clear() {
        for(int i = 1; i <= 4; i++) {
            horse[i] = new Horse(0, false);
        }

        visited = new boolean[32];
    }

    public static boolean move(int diceNum, int horseNum) {
        Horse h = horse[horseNum];

        int pos = h.idx;
        boolean flag = h.blueflag;

        // 끝부분이면 return
        if(pos == 100) return true;

        // 주사위 칸수만큼 이동
        for(int i = 0; i < diceNum; i++) {
            if(pos == 100) {
                horse[horseNum] = new Horse(pos, flag);
                visited[h.idx] = false;
                return true;
            }

            if(pos == 5 || pos == 10 || pos == 15) {
                if(flag) {
                    pos = map[pos].blue;
                } else {
                    pos = map[pos].red;
                }
            } else {
                pos = map[pos].red;
            }
        }

        // 주사위 칸 수 만큼 이동한 뒤 후처리
        if(pos == 100) {
            horse[horseNum] = new Horse(pos, flag);
            visited[h.idx] = false;
            return true;
        }

        // 파란색으로 가는 갈림길에 있다면
        if(pos == 5 || pos == 10 || pos == 15) flag = true;

        // 이미 다른 말이 방문했으면 가면 안됨
        if(visited[pos]) return false;

        temp_answer += map[pos].now;
        horse[horseNum] = new Horse(pos, flag);

        visited[h.idx] = false;
        visited[pos] = true;

        return true;
    }

    public static void dfs(int depth) {
        if(depth == 10) {
            temp_answer = 0;
            for(int i = 0; i < 10; i++) {
                if(!move(num[i], permNum[i])) {
                    clear();
                    return;
                }
            }
            answer = Math.max(answer, temp_answer);
            clear();
            return;
        }

        for(int i = 1; i <= 4; i++) {
            permNum[depth] = i;
            dfs(depth+1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            num[i] = in.nextInt();
        }

        setting();

        dfs(0);

        System.out.println(answer);
    }
}
