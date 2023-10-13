//11분 
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        List<String> ans = new ArrayList<>();
        List<String> name = new ArrayList<>();
        
        String in = "님이 들어왔습니다.";
        String out = "님이 나갔습니다.";
        
        for(String s : record) {
            String[] ss = s.split(" ");
            if(ss[0].equals("Enter")) {
                user.put(ss[1], ss[2]);
            } else if(ss[0].equals("Change")) {
                user.put(ss[1], ss[2]);
            }
        }
        
        for(String s : record) {
            String[] ss = s.split(" ");
            if(ss[0].equals("Enter")) {
                ans.add(user.get(ss[1])+in);
            } else if(ss[0].equals("Leave")) {
                ans.add(user.get(ss[1])+out);
            }
        }
        
        String[] answer = new String[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}