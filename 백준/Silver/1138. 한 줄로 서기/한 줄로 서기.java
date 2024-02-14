import java.util.*;

//쉬울 줄 알았는데..
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] taller = new int[n];
        for(int i = 0; i < n; i++) {
            taller[i] = in.nextInt();
        }

        int[] seat = new int[n];
        for(int i = 0; i < n; i++) {
            //count가 왼쪽 자리에 있는 큰 사람의 빈자리수
            int count = 0;
            for(int j = 0; j < n; j++) {
                //seat[j]가 0인 것은 이미 앉은 자리가 아닌지 확인하려고
                if(count == taller[i] && seat[j] == 0) {
                    seat[j] = i+1;
                    break;
                }
                //빈자리면 count값 올려줌
                if(seat[j] == 0) count++;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(seat[i]+" ");
        }
    }
}
