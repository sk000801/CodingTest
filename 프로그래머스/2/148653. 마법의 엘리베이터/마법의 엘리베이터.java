// 88이면 10*9 -> (-1)*2 총 11번
// 9분, 올림인 2가지 경우만 고려하면 성공
class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey != 0) {
            int nameogi = storey%10;
            storey /= 10;
            if(nameogi > 5 || (nameogi == 5 && storey%10 >= 5)) { //올림고려
                nameogi = 10 - nameogi;
                storey++;
            }
            answer += nameogi;
        }
        return answer;
    }
}