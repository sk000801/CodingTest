// 새로운 과제 시작 시간 -> 기존의 과제 중단
// 새로운 과제 끝 -> 멈춘 과제 이어 진행 , 여기서 바로 또 새로운 과제 시작 시간이면 이것부터
// 멈춘 과제 여러개 -> 가장 최근 애 부터
// plans -> 이름, 시작 시간, 걸리는 시간
// 38분인데 recur을 참조한.... 흑흑
import java.util.*;
class Solution {
    int idx = 0;
    
    public class Subject {
        String name;
        int start;
        int left;
        
        public Subject(String name, int start, int left) {
            this.name = name;
            this.start = start;
            this.left = left;
        }
    }
    
    public int change(String s) {
        String[] ss = s.split(":");
        return Integer.parseInt(ss[0])*60+Integer.parseInt(ss[1]);
    }
    
    public void recur(Stack<Subject> q, Subject next, int curTime, String[] answer) {
        if(q.isEmpty()) return;
        
        Subject cur = q.peek();
        
        if(curTime+cur.left <= next.start) {
            answer[idx++] = q.pop().name;
            recur(q, next, curTime+cur.left, answer);
        } else {
            cur.left -= next.start-curTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        Stack<Subject> q = new Stack<>();
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, (a, b) -> {
            int time1 = change(a[1]);
            int time2 = change(b[1]);
            return time1-time2;
        });
        
        for(int i = 0; i < plans.length; i++) {
            if(q.isEmpty()) {
                q.push(new Subject(plans[i][0], change(plans[i][1]), Integer.parseInt(plans[i][2])));
                continue;
            } 
            
            Subject cur = q.peek();
            Subject next = new Subject(plans[i][0], change(plans[i][1]), Integer.parseInt(plans[i][2]));
            
            if(cur.start+cur.left <= change(plans[i][1])) {
                //그치 여기서 재귀탐색이 필요할 것 같긴 하다
                recur(q, next, cur.start, answer);
            } else {
                cur.left -= change(plans[i][1])-cur.start;
            }
            
            q.push(next);
        }
        
        while(!q.isEmpty() && idx < answer.length) {
            Subject cur = q.pop();
            answer[idx++] = cur.name;
        }
        
        return answer;
    }
}