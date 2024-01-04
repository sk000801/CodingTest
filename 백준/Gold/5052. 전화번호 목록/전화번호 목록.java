import java.util.*;

//일관성 = 한 번호가 다른 번호의 접두어인 경우가 X
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(in.nextLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.nextLine());

            String[] phone = new String[n];
            for(int j = 0; j < n; j++) {
                phone[j] = in.nextLine();
            }

            Arrays.sort(phone);
            boolean flag = false;
            for(int j = 1; j < n; j++) {
                if(phone[j].startsWith(phone[j-1])) {
                    sb.append("NO").append("\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) sb.append("YES").append("\n");
        }

        System.out.println(sb);
    }

}
