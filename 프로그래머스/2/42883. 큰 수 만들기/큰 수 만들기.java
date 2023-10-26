class Solution {
    public String solution(String number, int k) {
        int length = number.length()-k;
        StringBuilder sb = new StringBuilder();
        char max ;
        int start = 0;
        int index = 0;
        
        //만들어줘야 하는 문자열의 개수만큼 for문을 돌려주고
        //가장 큰 수가 앞자리수가 되어야 하므로 앞자리 수 찾으면 다음 인덱스를 시작 인덱스로 설정
        //그렇게 정답 문자열에 붙여주면 완성
        //원래는 그냥 문자열에다 덧붙여줬는데 문자열은 메모리 낭비가 많이 되나봄
        //그래서 풀이에 있던 StringBuilder를 썼다.. 흑흑
        while(index < length) {
            max = 0;
            for(int j = start; j <= k+index; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j+1;
                }
            }
            sb.append(String.valueOf(max));
            index++;
        }

        return sb.toString();
    }
}