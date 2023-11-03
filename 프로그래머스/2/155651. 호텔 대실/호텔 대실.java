class Solution {
    public int change(String s) {
        return Integer.parseInt(s.split(":")[0])*60+Integer.parseInt(s.split(":")[1]);
    }
    public int solution(String[][] book_time) {
        int answer = 1;
        int[] time = new int[24*60+10];
        
        for(int i = 0; i < book_time.length; i++) {
            int start = change(book_time[i][0]);
            int fin = change(book_time[i][1]);
            
            time[start]++;
            time[fin+10]--;
        }
        
        for(int i = 1; i < time.length; i++) {
            //입실, 퇴실 사이의 시간에 누적합
            //그리고 최댓값을 반환하면 필요한 방 개수
            time[i] += time[i-1];
            if(answer < time[i]) {
                answer = time[i];
            }
        }
        return answer;
    }
}