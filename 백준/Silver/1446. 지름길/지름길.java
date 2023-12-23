import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = in.nextInt();

        //just 입력값 받아오는
        int[][] road = new int[n][3];
        //해당 위치?만큼 이동하는데 걸리는 최단거리
        int[] distance = new int[d+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        //just 입력된 최단거리값 저장
        List<List<int[]>> path = new ArrayList<>();
        for(int i = 0; i <= 10_000; i++) {
            path.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            road[i][0] = in.nextInt();
            road[i][1] = in.nextInt();
            road[i][2] = in.nextInt();

            if(road[i][1]-road[i][0] > road[i][2]) {
                path.get(road[i][1]).add(new int[]{road[i][0], road[i][2]});
            }
        }
        
        distance[0] = 0;
        for(int i = 1; i <= d; i++) {
            if(path.get(i).size() > 0) {
                for(int[] arr : path.get(i)) {
                    if(distance[arr[0]]+arr[1] > distance[i]) continue;
                    distance[i] = Math.min(distance[i-1]+1, distance[arr[0]]+arr[1]);
                }
                continue;
            }

            distance[i] = distance[i-1]+1;
        }

        System.out.println(distance[d]);
    }
}
