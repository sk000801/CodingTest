import java.util.*;
import java.io.*;

// 1~n*n까지의 번호가 매겨짐
// 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 자리를 잡는다
// 2. 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리를 잡는다
// 3. 행의 번호가 가장 작고 -> 열의 번호가 가장 작고

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] room;
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static class Room {
        int x, y;
        int empty, friend;
        
        public Room(int x, int y, int empty, int friend) {
            this.x = x;
            this.y = y;
            this.empty = empty;
            this.friend = friend;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        room = new int[n][n];

        int answer = 0;

        StringTokenizer st;
        for(int i = 0; i < n*n; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < 4; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            map.put(student, list);

            List<Room> possible = new ArrayList<>();
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    int empty = 0;
                    int friend = 0;

                    for(int r = 0; r < 4; r++) {
                        int nx = x+dx[r];
                        int ny = y+dy[r];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if(list.contains(room[nx][ny])) friend++;
                        if(room[nx][ny] == 0) empty++;
                    }

                    possible.add(new Room(x, y, empty, friend));
                }
            }

            possible.sort((a, b) -> {
                if(a.friend == b.friend) {
                    if(a.empty == b.empty) {
                        if(a.x == b.x) {
                            return a.y-b.y;
                        }
                        return a.x-b.x;
                    }
                    return b.empty-a.empty;
                }  
                return b.friend-a.friend;
            });

            for(int r = 0; r < possible.size(); r++) {
                Room japyo = possible.get(r);
                if(room[japyo.x][japyo.y] == 0) {
                    room[japyo.x][japyo.y] = student;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int student = room[i][j];
                List<Integer> list = map.get(student);
                int count = 0;

                for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];

                    if(nx<0||ny<0||nx>=n||ny>=n) continue;
                    if(list.contains(room[nx][ny])) count++;
                }

                if(count == 1) answer += 1;
                else if(count == 2) answer += 10;
                else if(count == 3) answer += 100;
                else if(count == 4) answer += 1000;
            }
        }

        System.out.println(answer);
    }
}
