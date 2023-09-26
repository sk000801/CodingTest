import java.util.*;

public class Main {
    static List<int[]> snake = new ArrayList<>();
    static int[] dx =  {0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int n;
    public static boolean isFinish(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n) return true;

        for(int i = 0; i < snake.size(); i++) {
            int[] cur = snake.get(i);
            if(x == cur[0] && y == cur[1]) return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.next());
        int[][] board = new int[n][n];

        int k = Integer.parseInt(in.next());
        for(int i = 0; i < k; i++) {
            int x = Integer.parseInt(in.next())-1;
            int y = Integer.parseInt(in.next())-1;
            board[x][y] = 1;
        }

        int rotate = Integer.parseInt(in.next());
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < rotate; i++) {
            int num = Integer.parseInt(in.next());
            String s = in.next();
            map.put(num, s);
        }

        snake.add(new int[]{0, 0});

        int time = 0;
        int curX = 0;
        int curY = 0;
        int idx = 0;
        while(true) {
            time++;

            int nx = curX+dx[idx];
            int ny = curY+dy[idx];

            if(isFinish(nx, ny)) break;
            
            snake.add(new int[]{nx, ny});
            if(board[nx][ny] == 1) {
                board[nx][ny] = 0;
            } else {
                snake.remove(0);
            }

            if(map.keySet().contains(time)) {
                if(map.get(time).equals("D")) {
                    idx++;
                    if(idx == 4) idx = 0;
                } else {
                    idx--;
                    if(idx == -1) idx = 3;
                }
            }

            curX = nx;
            curY = ny;
        }

        System.out.println(time);
    }
}
