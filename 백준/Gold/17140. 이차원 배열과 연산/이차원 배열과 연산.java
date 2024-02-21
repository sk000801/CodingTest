import java.util.*;
import java.io.*;

// 크기가 3x3인 배열 , 인덱스는 1부터 시작
// r 연산 -> A의 모든 행에 대에 정렬 수행, if(행 >= 열)
// c 연산 -> A의 모든 열에 대해 정렬 수행, if(행 < 열)

// 이렇게 정렬하기 위해서는 각각의 수가 몇 번 나왔는지 알아야 함
// 그 다음 수의 등장 횟수 오름차순, 수의 오름차순으로 정렬
// 그리고 배열 A에 정렬된 결과를 넣어줌

public class Main {
    static int[][] arr = new int[101][101];
    static int row = 3;
    static int column = 3;

    public static void hang() {
        int new_column = 0;
        for(int i = 1; i <= row; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = 1; j <= column; j++) {
                if(arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
                arr[i][j] = 0;
            }

            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            
            List<Integer> values = new ArrayList<>(map.values());
            Collections.sort(values);

            //System.out.print(map);

            new_column = Math.max(keys.size()*2, new_column);

            boolean[] visited = new boolean[101];
            int index = 0;
            for(int j = 0; j < values.size(); j++) {
                int value = values.get(j);
                for(int r = 0; r < keys.size(); r++) {
                    int idx = keys.get(r);
                    if(index > 100) break;
                    if(value == map.get(idx) && !visited[idx]) {
                        visited[idx] = true;
                        arr[i][index+1] = idx;
                        arr[i][index+2] = value;
                        index += 2;
                        break;
                    }
                }
            }
        }

        column = Math.min(100, new_column);
    }

    public static void yeol() {
        int new_row = 0;
        for(int i = 1; i <= column; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = 1; j <= row; j++) {
                if(arr[j][i] == 0) continue;
                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0)+1);
                arr[j][i] = 0;
            }

            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            
            List<Integer> values = new ArrayList<>(map.values());
            Collections.sort(values);

            new_row = Math.max(keys.size()*2, new_row);

            boolean[] visited = new boolean[101];
            int index = 0;
            for(int j = 0; j < values.size(); j++) {
                int value = values.get(j);
                for(int r = 0; r < keys.size(); r++) {
                    int idx = keys.get(r);
                    if(index > 100) break;
                    if(value == map.get(idx) && !visited[idx]) {
                        visited[idx] = true;
                        arr[index+1][i] = idx;
                        arr[index+2][i] = value;
                        index += 2;
                        break;
                    }
                }
            }
        }

        row = Math.min(100, new_row);
    }

    public static void print() {
        for(int i = 1; i <= 6; i++) {
            for(int j = 1; j <= 6; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while(true) {
            if(count > 100) break;

            if(arr[r][c] == k) break;

            if(row >= column) { //모든 행에 대해 정렬
                hang();
            } else { //모든 열에 대해 정렬
                yeol();
            }

            //System.out.println(row+" "+column);
            //print();

            count++;
        }

        System.out.println(count > 100 ? -1 : count);
    }
}
