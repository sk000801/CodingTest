import java.util.*;
import java.io.*;

// 나누려고 하는 조의 개수 = k
// 아예 2개씩 묶어서 가장 작은 차이의 값들을 합쳐줌
public class Main {
    static int n, k;
    static int[] student;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        student = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            list.add(student[i]-student[i-1]);
        }

        Collections.sort(list);

        for(int i = 0; i < n-k; i++) {
            answer += list.get(i);
        }

        System.out.println(answer);
    }
}
