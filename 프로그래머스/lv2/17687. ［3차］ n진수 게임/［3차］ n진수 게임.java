//8분 48초
class Solution {
    // n진법 t개 m명 p의 순서
    public String solution(int n, int t, int m, int p) {
        int count = 1;
        int tubeCount = 0;
        String answer = "";
        String allNum = "0";
        int allCount = m*t+p;
        for(int i = 1; i <= allCount; i++) {
            allNum += Integer.toString(i, n);
        }
        int num = p-1;
        while(answer.length() < t) {
            answer += String.valueOf(allNum.charAt(num));
            num += m;
        }
        return answer.toUpperCase();
    }
}