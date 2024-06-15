import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        if(sort_by.equals("code")) {
            Arrays.sort(data, (a, b) -> a[0]-b[0]);
        } else if(sort_by.equals("date")) {
            Arrays.sort(data, (a, b) -> a[1]-b[1]);            
        } else if(sort_by.equals("maximum")) {
            Arrays.sort(data, (a, b) -> a[2]-b[2]);            
        } else {
            Arrays.sort(data, (a, b) -> a[3]-b[3]);            
        }
        
        List<int[]> list = new ArrayList<>();
        int idx = -1;
        if(ext.equals("code")) idx = 0;
        else if(ext.equals("date")) idx = 1;
        else if(ext.equals("maximum")) idx = 2;
        else idx = 3;
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][idx] < val_ext) {
                list.add(new int[] {data[i][0], data[i][1], data[i][2], data[i][3]});
            }
        }
        
        int[][] answer = new int[list.size()][4];
        for(int i = 0; i < answer.length; i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
            answer[i][2] = list.get(i)[2];
            answer[i][3] = list.get(i)[3];
        }
        
        return answer;
    }
}