import java.io.*;
import java.util.*;

// 62분
// 문제 그대로 따라가면 되지 않을까..?

public class Main {
    static int n;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static List<Tree> list = new ArrayList<>();
    static Deque<Integer> dead = new LinkedList<>();
    static int[][] add; //추가양분
    static int[][] energy; //양분

    static class Tree {
        int x;
        int y;
        int age;
        boolean isDead;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static void spring() {
        for(int i = 0; i < list.size(); i++) {
            Tree cur = list.get(i);

            if(add[cur.x][cur.y] < cur.age) {
                dead.add(i);
                continue;
            }

            add[cur.x][cur.y] -= cur.age;
            cur.age++;
        }
    }

    public static void summer() {
        while(!dead.isEmpty()) {
            int idx = dead.pollLast();

            Tree cur = list.get(idx);

            int val = cur.age/2;

            add[cur.x][cur.y] += val;

            cur.isDead = true;
        }
    }

    public static void fall() {
        List<Tree> newTrees = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            Tree cur = list.get(i);

            if(!cur.isDead) {
                if(cur.age % 5 == 0) {
                    for(int j = 0; j < 8; j++) {
                        int nx = cur.x+dx[j];
                        int ny = cur.y+dy[j];

                        if(nx<0||ny<0||nx>=n||ny>=n) continue;

                        newTrees.add(new Tree(nx, ny, 1));
                    }
                }     
            }
        }

        for(Tree tree : list) {
            if(!tree.isDead) {
                newTrees.add(tree);
            } 
        }

        list = newTrees;
    }

    public static void winter() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                add[i][j] += energy[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        add = new int[n][n];
        energy = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(add[i], 5); 
            for(int j = 0; j < n; j++) {
                energy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            list.add(new Tree(x, y, z));
        }

        Collections.sort(list, (a, b) -> a.age-b.age);

        for(int i = 0; i < k; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(list.size());
    }
}
