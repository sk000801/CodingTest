// 0, 1, 2의 3진법으로 생각하는게 좋음
class Solution {
    String[] nums = {"4", "1", "2"};
    public String solution(int n) {
        String answer = "";
        while(n > 0) {
            answer = nums[n%3]+answer;
            n = n/3-(n%3==0?1:0);
        }
        return answer;
    }
}