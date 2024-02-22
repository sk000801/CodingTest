import java.util.*;
import java.io.*;

// 마법사가 n*n에 파이어볼 m개 발사
// 위치(x, y)와 질량 m, 방향 d, 속력 s를 가짐
// 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동
// 같은 칸에 여러 개의 파이어볼이 있을 수도
// 이동 끝나면 if(2개 이상의 파이어볼이 있을 때)
// 얘네는 하나로 합쳐짐, 파이어볼은 4개로 나뉘어짐
// 질량 l/5, 속력 l/개수, 방향 모두 홀 or 짝 0,2,4,6 아니면 1,3,5,7
// 질량이 0인 파이어볼은 소멸되어 없어짐

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static class fireball {
        int r, c, m, s, d;
        public fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<fireball> list = new ArrayList<>();
        List<fireball>[][] map = new ArrayList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int mm = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new fireball(x, y, mm, s, d));
        }

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < list.size(); j++) {
                fireball cur = list.get(j);

                //여기서 +n을 하는게 음수가 나올 수도 있어서
                int x = (cur.r+dx[cur.d]*(cur.s%n)+n)%n;
                int y = (cur.c+dy[cur.d]*(cur.s%n)+n)%n;
                cur.r = x;
                cur.c = y;
                map[cur.r][cur.c].add(cur);
            }

            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    if(map[x][y].size() == 1) {
                        map[x][y].clear(); // 근데 왜 하나 남아도 클리어해?
                        continue;
                    }

                    int ms = 0;
                    int ss = 0;
                    int odd = 0;
                    int even = 0;
                    int size = map[x][y].size();

                    for(int r = 0; r < map[x][y].size(); r++) {
                        fireball cur = map[x][y].get(r);

                        ms += cur.m;
                        ss += cur.s;
                        if(cur.d % 2 == 1) odd++;
                        else even++;

                        list.remove(cur);
                    }
                    map[x][y].clear();

                    ms /= 5;
                    if(ms == 0) continue;
                    ss /= size;

                    if(odd == size || even == size) {
                        for(int z = 0; z < 8; z += 2) {
                            list.add(new fireball(x, y, ms, ss, z));
                        }
                    } else {
                        for(int z = 1; z < 8; z += 2) {
                            list.add(new fireball(x, y, ms, ss, z));
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            answer += list.get(i).m;
        }

        System.out.println(answer);
    }   
}
