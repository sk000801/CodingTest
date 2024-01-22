// 시청자들이 가장 많이 보는 구간에 공익 광고 넣기
// 시청자 수 -> 최대 300_000
// play_time = 전체영상시간 , adv_time = 공익광고길이
// return "공익광고 시작 시간"

// for문 -> 처음에는 해당 초 인덱스에 +1을 모두 하려 했는데 이건 시간 초과
// 그래서 누적합을 구해야 함
// 최대 99시간? 100*60*60 = 360000
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time)) return "00:00:00";
        
        long[] seconds = new long[360001];
        long[] startTime = new long[logs.length];
        long[] finTime = new long[logs.length];
        
        long playTimeSec = 3600*Long.parseLong(play_time.substring(0, 2)) + 60*Long.parseLong(play_time.substring(3, 5))+Long.parseLong(play_time.substring(6, 8));
        long advTimeSec = 3600*Long.parseLong(adv_time.substring(0, 2)) + 60*Long.parseLong(adv_time.substring(3, 5))+Long.parseLong(adv_time.substring(6, 8));
        
        for(int i = 0; i < logs.length; i++) {
            String s = logs[i];
            long start = 60*60*Long.parseLong(s.substring(0, 2))+60*Long.parseLong(s.substring(3, 5))+Long.parseLong(s.substring(6, 8));
            long fin = 60*60*Long.parseLong(s.substring(9, 11))+60*Long.parseLong(s.substring(12, 14))+Long.parseLong(s.substring(15, 17));
            startTime[i] = start;
            finTime[i] = fin;
        }
        
        for(int i = 0; i < logs.length; i++) {
            seconds[(int)startTime[i]]++;
            seconds[(int)finTime[i]]--;
        }
        
        //매초마다 시청자 숫자 값을 가짐
        //이전 시간 끝 시간의 음수 값이 계산됨 (정확히 모르겠음)
        for(int i = 1; i < playTimeSec; i++) {
            seconds[i] += seconds[i-1];
        }
        
        //이전값 누적
        for(int i = 1; i < playTimeSec; i++) {
            seconds[i] += seconds[i-1];
        }
             
        long max = 0;
        long maxTime = 0;
        for(int i = 0; i <= playTimeSec-advTimeSec; i++) {
            long sum = seconds[(int)(i+advTimeSec-1)];
            
            if(sum > 0 && i >= 1) {
                sum -= seconds[i-1];
            }
            
            if(max < sum) {
                max = sum;
                maxTime = i;
            }
        }
        
        String answer = "";
        
        String hour = ""+maxTime/3600;
        maxTime%= 3600;
        if(hour.length() == 1) answer += "0"+hour;
        else answer += hour;
        answer += ":";
        
        String minute = ""+maxTime/60;
        maxTime %= 60;
        if(minute.length() == 1) answer += "0"+minute;
        else answer += minute;
        answer += ":";
        
        String second = ""+maxTime;
        if(second.length() == 1) answer += "0"+second;
        else answer += second;
        return answer;
    }
}