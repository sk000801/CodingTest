import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char last = words[0].charAt(words[0].length()-1);
        Set<String> word = new HashSet<>();
        word.add(words[0]);
        
        for(int i = 1; i < words.length; i++) {
            char newLast = words[i].charAt(words[i].length()-1);
            if(word.contains(words[i]) || last != words[i].charAt(0)) {
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
                answer[1] = (i+1)%n == 0 ? (i+1)/ n : (i+1)/n+1;
                return answer;
            }
            last = newLast;
            word.add(words[i]);
        }

        return new int[] {0, 0};
    }
}