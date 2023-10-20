import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        Integer[] numbers2 = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }
        
        Arrays.sort(numbers2, (a, b) -> {
            String a1 = a.toString();
            String b1 = b.toString();
            
            int num1 = Integer.parseInt(a1+b1);
            int num2 = Integer.parseInt(b1+a1);
            
            return num2-num1;
        });
        
        String answer = "";
        for(int i = 0; i < numbers2.length; i++) {
            answer += numbers2[i].toString();
        }
        
        if(answer.replaceAll("0", "").equals("")) answer = "0";
        return answer;
    }
}