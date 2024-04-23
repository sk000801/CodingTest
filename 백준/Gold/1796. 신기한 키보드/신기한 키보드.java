import java.util.*;

// 버튼 세 개 -> 왼쪽, 오른쪽, 엔터키
// 여기서 엔터키는 문자열을 컴퓨터에 전송해 컴퓨터 화면에 출력하는 역할을 함
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Character> set = new HashSet<>();

        String s = in.nextLine();

        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        List<Character> list = new ArrayList<>(set);
        Collections.sort(list);

        int n = list.size();

        int[] leftDist = new int[n];
        int[] rightDist = new int[n];

        Arrays.fill(leftDist, 100);

        // 알파벳 마다 가장 왼쪽/오른쪽에 있는 인덱스 찾기
        for(int i = 0; i < s.length(); i++) {
            int alpha = list.indexOf(s.charAt(i));

            leftDist[alpha] = Math.min(i, leftDist[alpha]);
            rightDist[alpha] = Math.max(i, rightDist[alpha]);
        }

        // 0은 왼쪽에서 출발, 1은 오른쪽에서 출발
        int[][] dp = new int[n][2];

        int left = leftDist[0];
        int right = rightDist[0];
        int dist = right-left;
        dp[0][0] = left+dist;
        dp[0][1] = right+dist;

        // 이전 값을 알아야 현재 커서의 위치를 알 수 있음
        for(int i = 1; i < n; i++) {
            int l = leftDist[i-1];
            int r = rightDist[i-1];

            left = leftDist[i];
            right = rightDist[i];
            dist = right-left;

            // 최소(이전왼쪽-현재오른쪽, 이전왼쪽-현재왼쪽)
            dp[i][0] = Math.min(dp[i-1][0]+Math.abs(left-r), dp[i-1][1]+Math.abs(left-l))+dist;
            // 최소(이전오른쪽-현재오른쪽, 이전오른쪽-현재왼쪽)
            dp[i][1] = Math.min(dp[i-1][0]+Math.abs(right-r), dp[i-1][1]+Math.abs(right-l))+dist;
        }

        int min = Math.min(dp[n-1][0], dp[n-1][1])+s.length();
        System.out.println(min);
    }
}
