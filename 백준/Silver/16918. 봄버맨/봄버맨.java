import java.util.*;

// 초마다 반복되는 행위를 코드로 잘 표현할 수 있어야 함 ㅠㅠ
public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        StringTokenizer st = new StringTokenizer(in.nextLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] burst = new int[r][c];

        String[][] area = new String[r][c];
        for(int i = 0; i < r; i++) {
            String[] s = in.nextLine().split("");
            for(int j = 0; j < c; j++) {
                area[i][j] = s[j];
                if(area[i][j].equals("O")) burst[i][j] = 3;
            }
        }

        int time = 0;
        while(time < n) {
            time++;

            if(time % 2 == 0) {
                for(int i = 0; i < r; i++) {
                    for(int j = 0; j < c; j++) {
                        if(area[i][j].equals(".")) {
                            area[i][j] = "O";
                            burst[i][j] = time+3;
                        }
                    }
                }
            } else {
                for(int i = 0; i < r; i++) {
                        for(int j = 0; j < c; j++) {
                            if(burst[i][j] == time) {
                                area[i][j] = ".";
                                for(int x = 0; x < 4; x++) {
                                    int nx = i+dx[x];
                                    int ny = j+dy[x];

                                    if(nx<0||nx>=r||ny<0||ny>=c) continue;
                                    if(burst[nx][ny] != time && area[nx][ny].equals("O")) {
                                        area[nx][ny] = ".";
                                        burst[nx][ny] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sb.append(area[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
