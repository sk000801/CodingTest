import java.util.*;
class Solution {
    public boolean isChar(char c) {
        if(c >= 'a' && c <= 'z') return true;
        return false;
    }
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        if(str1.equals(str2)) return 65536;
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < str1.length()-1; i++) {
            if(!isChar(str1.charAt(i)) || !isChar(str1.charAt(i+1))) continue;
            String a = str1.substring(i, i+2);
            if(map1.keySet().contains(a)) {
                map1.put(a, map1.get(a)+1);
            } else {
                map1.put(a, 1);
            }
            set.add(a);
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
            if(!isChar(str2.charAt(i)) || !isChar(str2.charAt(i+1))) continue;
            String a = str2.substring(i, i+2);
            if(map2.keySet().contains(a)) {
                map2.put(a, map2.get(a)+1);
            } else {
                map2.put(a, 1);
            }
            set.add(a);
        }
        
        List<String> key1 = new ArrayList<>(map1.keySet());
        List<String> key2 = new ArrayList<>(map2.keySet());
        List<String> all = new ArrayList<>(set);
        
        int hap = 0;
        int gyo = 0;
        
        for(String s : all) {
            if(key1.contains(s) && key2.contains(s)) {
                hap += Math.max(map1.get(s), map2.get(s));
                gyo += Math.min(map1.get(s), map2.get(s));
            } else if(key1.contains(s)) {
                hap += map1.get(s);
            } else {
                hap += map2.get(s);
            }
        }
        
        int answer = (int) ((double)gyo/hap*65536);
        return answer;
    }
}