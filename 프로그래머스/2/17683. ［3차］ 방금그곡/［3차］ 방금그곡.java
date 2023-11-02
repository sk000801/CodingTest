import java.util.*;
// 악 생각해보니 #을 고려하지 않은 듯
// 40분은 족히 걸린듯.. 내 효율성
class Solution {
    String[] sharp = {"C#", "D#", "F#", "G#", "A#"};
    String[] change = {"c", "d", "f", "g", "a"};
    public String find(String s, Map<String, String> map) {
        List<String> list = new ArrayList<>(map.keySet());
        for(int i = 0; i < list.size(); i++) {
            if(map.get(list.get(i)).equals(s)) {
                return list.get(i);
            }
        }
        return "(None)";
    }
    public String solution(String m, String[] musicinfos) {
        String[] newInfo = new String[musicinfos.length];
        for(int j = 0; j < newInfo.length; j++) {
            String s = musicinfos[j];
            for(int i = 0; i < sharp.length; i++) {
                s = s.replaceAll(sharp[i], change[i]);
            }
            newInfo[j] = s;
        }
        
        for(int i = 0; i < sharp.length; i++) {
            m = m.replaceAll(sharp[i], change[i]);
        }
        
        Map<String, String> song = new LinkedHashMap<>();
        Map<String, Integer> time = new LinkedHashMap<>();
        
        for(String s : newInfo) {
            String[] info = s.split(",");
            int start = Integer.parseInt(info[0].split(":")[0])*60+Integer.parseInt(info[0].split(":")[1]);
            int fin = Integer.parseInt(info[1].split(":")[0])*60+Integer.parseInt(info[1].split(":")[1]);
            int playTime = fin-start;
            String akbo = "";
            if(info[3].length() >= playTime) akbo = info[3].substring(0, playTime);
            else {
                int num = playTime/info[3].length();
                int nameogi = playTime%info[3].length();
                akbo = info[3].repeat(num)+info[3].substring(0, nameogi);
            }
            
            if(akbo.contains(m)) {
                song.put(info[2], akbo);
                time.put(info[2], playTime);
            }
        }
        
        if(song.size() == 0) return "(None)";
        
        List<Integer> times = new ArrayList<>(time.values());
        Collections.sort(times, Collections.reverseOrder());
        List<String> titles = new ArrayList<>(song.keySet());
        
        String answer = "";
        for(String s : titles) {
            if(time.get(s) == times.get(0)) {
                answer = s;
                break;
            }
        }
        
        return answer;
    }
}