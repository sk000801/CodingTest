import java.io.*;
import java.util.*;

// 키가 큰 순으로 입력받은대로 리스트에 삽입!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] people = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> order = new ArrayList<>();
        for(int i = n-1; i >= 0; i--) {
            order.add(people[i], i+1);
        }

        for(int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i)+" ");
        }
    }
}