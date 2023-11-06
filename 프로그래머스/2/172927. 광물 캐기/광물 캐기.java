// picks 다이아/철/돌 각각의 곡괭이 수
// minerals 다이어/철/돌 중 하나
// 곡괭이 하나당 5번 광물 캘 수 있음
// 49분 왜 이럴까ㅠㅠㅠㅠㅠ
import java.util.*;
class Solution {
    int[] dia = {1, 1, 1}; //0
    int[] iron = {5,1,1}; //1
    int[] stone = {25,5,1}; //2
    int answer = Integer.MAX_VALUE;
    
    public int getNum(String s) {
        if(s.equals("diamond")) return 0;
        else if (s.equals("iron")) return 1;
        return 2;
    }
    
    public int count(int len, int[] ans, int[] picks, String[] minerals) {
        int piro = 0;
        for(int i = 0; i < ans.length; i ++) {
            for(int j = 5*i; j < 5*i+5; j++) {
                if(j >= len*5) return piro;
                if(j >= minerals.length) return piro;
                
                int num = getNum(minerals[j]);
                if(j%5==0) picks[ans[i]]--;
                if(picks[ans[i]] < 0) return 100000;

                if(ans[i] == 0) piro += dia[num];
                else if(ans[i] == 1) piro += iron[num];
                else piro += stone[num];
            }
        }
        return piro;
    }
    
    public void dfs(int len, int gokNum, int[] ans, int depth, int[] picks, String[] minerals) {
        if(depth == gokNum) {
            // if(isAll(picks, ans)) {
                int[] newPick = new int[picks.length];
                for(int i = 0; i < 3; i++) {
                    newPick[i] = picks[i];
                }
                answer = Math.min(answer, count(len, ans, newPick, minerals));
            // }
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            ans[depth] = i;
            dfs(len, gokNum, ans, depth+1, picks, minerals);
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int len = Arrays.stream(picks).sum();
        int gokNum = minerals.length % 5 == 0 ? minerals.length/5 : minerals.length/5 + 1;
        int[] val = new int[gokNum];
        Arrays.fill(val, -1);
        
        dfs(len, gokNum, val, 0, picks, minerals);
        return answer;
    }
}