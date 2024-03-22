import java.util.*;

//3시간동안 눈싸움 한 듯..
public class Main {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int answer = 0;

    public static class Shark {
        int x;
        int y;
        int dir;
        int sum = 0;

        public Shark(int x, int y, int dir, int sum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sum = sum;
        }
    }

    public static class Fish {
        int x, y;
        int num;
        int dir;
        boolean dead = false;

        public Fish(int x, int y, int num, int dir, boolean dead) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.dead = dead;
        }
    }

    public static void moveFish(int[][] area, Fish fish, List<Fish> fishes) {
        if(!fish.dead) {
            for(int i = 0; i < 8; i++) {
                int newDir = (fish.dir+i)%8;

                int nx = fish.x+dx[newDir];
                int ny = fish.y+dy[newDir];

                // 움직인 위치가 상어가 있는 곳일 때
                if(nx<0||ny<0||nx>=4||ny>=4||area[nx][ny] == -1) continue;
                area[fish.x][fish.y] = 0;    

                if(area[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish cur = fishes.get(area[nx][ny]-1);
                    cur.x = fish.x;
                    cur.y = fish.y;
                    area[fish.x][fish.y] = cur.num;

                    fish.x = nx;
                    fish.y = ny;
                }

                area[nx][ny] = fish.num;
                fish.dir = newDir;      
                return;
            }
        }
    }

    public static void dfs(int[][] area, Shark shark, List<Fish> fishes) {
        answer = Math.max(answer, shark.sum);

        for(Fish fish : fishes) {
            moveFish(area, fish, fishes);
        }

        for(int i = 1; i < 4; i++) {
            int nx = shark.x+dx[shark.dir]*i;
            int ny = shark.y+dy[shark.dir]*i;

            if(nx<0||ny<0||nx>=4||ny>=4||area[nx][ny] <= 0) continue;

            int[][] newArr = new int[4][4];
            for(int x = 0; x < 4; x++) {
                for(int y = 0; y < 4; y++) {
                    newArr[x][y] = area[x][y];
                }
            }

            List<Fish> newFish = new ArrayList<>();
            for(int r = 0; r < fishes.size(); r++) {
                Fish f = fishes.get(r);
                newFish.add(new Fish(f.x, f.y, f.num, f.dir, f.dead));
            }

            // 원래 상어의 자리 number를 0으로 두고 현재 물고기의 자리를 상어 자리로
            newArr[shark.x][shark.y] = 0;
            Fish cur = newFish.get(area[nx][ny]-1);
            Shark newShark = new Shark(cur.x, cur.y, cur.dir, shark.sum+cur.num);
            cur.dead = true;
            newArr[cur.x][cur.y] = -1;

            dfs(newArr, newShark, newFish);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Fish> fishes = new ArrayList<>();
        int[][] area = new int[4][4];
        Shark shark;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int num = in.nextInt();
                int dir = in.nextInt()-1;

                area[i][j] = num;
                fishes.add(new Fish(i, j, num, dir, false));
            }
        }

        Collections.sort(fishes, (a, b) -> a.num-b.num);

        Fish cur = fishes.get(area[0][0]-1);
        shark = new Shark(0, 0, cur.dir, cur.num);
        cur.dead = true;
        area[0][0] = -1;

        dfs(area, shark, fishes);

        System.out.println(answer);
    }
}
