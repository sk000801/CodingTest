//10분..?
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        for(long l = left; l <= right; l++) {
            int x = (int)(l/n);
            int y = (int)(l%n);
            answer[(int)(l-left)] = Math.max(x, y)+1;
        }
        return answer;
    }
}