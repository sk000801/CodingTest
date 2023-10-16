//14분
//01인 곳을 찾아 10으로 바꿔주면 최소 큰 값(?)이 됨! 홀수는
//짝수는 그냥 1만 더하면 최소 큰 값
class Solution {
    public String findNum(String num) {
        int idx = num.lastIndexOf("0");
        if(idx == -1) return "10"+num.substring(1);
        return num.substring(0, idx)+"10"+num.substring(idx+2, num.length());
    }
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2 == 0) answer[i] = numbers[i]+1;
            else {
                String num = Long.toString(numbers[i], 2);
                answer[i] = Long.valueOf(findNum(num), 2);
            }
        }
        return answer;
    }
}