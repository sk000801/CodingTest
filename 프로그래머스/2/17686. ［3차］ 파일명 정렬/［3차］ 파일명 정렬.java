//21분 ..?
import java.util.*;
class Solution {
    public int separate(String file, String head) {  
        file = file.substring(head.length());
        String result = "";
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);
            if (Character.isDigit(c) && result.length() < 5) 
                result += c;
            else break;
        }
        return Integer.valueOf(result);
    }
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String head1 = a.split("[0-9]")[0];
            String head2 = b.split("[0-9]")[0];
            
            int num1 = separate(a, head1);
            int num2 = separate(b, head2);
            
            if(head1.toLowerCase().equals(head2.toLowerCase())) return num1-num2;
               
            return head1.toLowerCase().compareTo(head2.toLowerCase());
                
        });
            
        return files;
    }
}