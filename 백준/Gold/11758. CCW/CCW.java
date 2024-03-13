import java.util.*;

// 첫번째 선분보다 두번째 선분의 기울기가 크면 시계방향
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();

        double val1 = (y2-y1)*(x3-x2);
        double val2 = (y3-y2)*(x2-x1);
        if(val1-val2 == 0) {
            System.out.println(0);
            return;
        }

        if(val1-val2 > 0) {
            System.out.println(-1);
            return;
        } 

        System.out.println(1);
    }
}
