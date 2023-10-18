class Solution {
    int zeroCount = 0;
    int oneCount = 0;
    public void divide(int x, int y, int len, int[][] arr) {
        int val = arr[x][y];
        int count = 0;
        
        for(int i = x; i < x+len; i++) {
            for(int j = y; j < y+len; j++) {
                if(arr[i][j] == val) count++;
            }
        }
        
        if(count == len*len) {
            if(val == 0) zeroCount++;
            else oneCount++;
            return;
        }
        
        divide(x, y, len/2, arr);
        divide(x+len/2, y, len/2, arr);
        divide(x, y+len/2, len/2, arr);
        divide(x+len/2, y+len/2, len/2, arr);
    }
    
    public int[] solution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        divide(0, 0, arr[0].length, arr);
        return new int[]{zeroCount, oneCount};
    }
}