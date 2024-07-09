import java.util.*;

public class Main {
    static String[] yeonsan = new String[]{"", "+", "-"};
    static StringBuffer sb;

    public static int cal(String[] temp) {
        int num = 0;
        String s = "";

        for(int i = 0; i < temp.length; i++) {
            s += (i+1)+temp[i];
        }
        s += String.valueOf(temp.length+1);

        s = s.replaceAll(" ", "");

        // 여기가 왜 그냥 공백을 줄이는거 빼고는 안되는지
        //String[] nums = s.replace("+", " ").replace("-", " ").split(" ");

        String[] nums = s.split("[\\-\\+]");

        num += Integer.parseInt(nums[0]);
        int idx = 1;
        for(int i = 0; i < temp.length; i++) {
            if(temp[i].equals("+")) {
                num += Integer.parseInt(nums[idx++]);
            } 

            if(temp[i].equals("-")) {
                num -= Integer.parseInt(nums[idx++]);
            }            
        }

        return num;
    }

    public static void dfs(int depth, int num, String[] temp) {
        if(depth == num-1) {
            int res = cal(temp);
            if(res == 0) {
                for(int i = 0; i < num-1; i++) {
                    if(temp[i].equals("")) temp[i] = " ";
                    sb.append((i+1)).append(temp[i]);
                }
                sb.append(num);
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < 3; i++) {
            temp[depth] = yeonsan[i];
            dfs(depth+1, num, temp);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        sb = new StringBuffer();

        int tc = in.nextInt();
        for(int i = 0; i < tc; i++) {
            int n = in.nextInt();

            String[] temp = new String[n-1];
            dfs(0, n, temp);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
