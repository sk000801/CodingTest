import java.util.*;

// 정사각행렬의 거듭제곱,, 그러나 효율성을 곁들인,,
// A^B = B가 홀수, 짝수일 때의 경우를 나눠 거듭제곱으로 표현해 시간복잡도를 줄임
// 이걸 재귀로 풀어야됨!!
// 풀이 읽고 풀어서 40분
public class Main {
    static int n;
    public static long[][] divide(long[][] arr, long exp) {
        if(exp == 1) return arr;

        long[][] res = divide(arr, exp/2);

        res = multiple(res, res);

        if(exp % 2 == 1) res = multiple(res, arr);

        return res;
    }

    public static long[][] multiple(long[][] arr1, long[][] arr2) {
        long[][] res = new long[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < n; r++) {
                    res[i][j] += arr1[i][r]*arr2[r][j];
                }
                res[i][j] %= 1000;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = (int) in.nextLong();
        long[][] val = new long[n][n];
        long[][] res = new long[n][n];

        long b = in.nextLong();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 처음 입력받은 값을 미리 나눠놓지 않으면 모듈러 연산 적용이 안됨
                // 1은 바로 그 배열 값을 반환하므로
                val[i][j] = in.nextLong()%1000;
                res[i][j] = val[i][j];
            }
        }

        res = divide(val, b);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
