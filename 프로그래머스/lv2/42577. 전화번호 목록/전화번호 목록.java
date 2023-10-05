// 7분 아 이런 바보...
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 1; i < phone_book.length; i++) {
            phone_book[i] = phone_book[i].replaceAll(" ", "");
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
            
        }
        
        return true;
    }
}