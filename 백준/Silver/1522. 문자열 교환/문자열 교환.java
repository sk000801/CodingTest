import java.util.*;

// 인덱스의 처음부터 끝까지 시작해 a의 개수만큼 a가 연속되게 만들어줘야함
// 그래서 b 개수가 나오면 그냥 더해주면 그게 교환 횟수임
// 또한 문자열 원형!!! -> 나눗셈 연산으로 인덱스 오버 해결
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int min = Integer.MAX_VALUE;

        int aNum = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') aNum++;
        }

        for(int i = 0; i < s.length(); i++) {
            int bNum = 0;
            for(int j = i; j < i+aNum; j++) {
                if(s.charAt(j%s.length()) == 'b') bNum++;
            }
            min = Math.min(bNum, min);
        }

        System.out.println(min);
    }
}
