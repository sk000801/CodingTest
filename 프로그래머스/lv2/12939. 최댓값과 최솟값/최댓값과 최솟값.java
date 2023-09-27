class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] num = s.split(" ");
        for(int i = 0; i < num.length; i++) {
            min = Math.min(min, Integer.parseInt(num[i]));
            max = Math.max(max, Integer.parseInt(num[i]));
        }
        String answer = min+" "+max;
        return answer;
    }
}