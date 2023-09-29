class Solution {
    public int getGCD(int a, int b) {
        int min = Math.min(a, b);
        
        for(int i = min; i >= 1; i--) {
            if(b%i == 0 && a%i == 0) return i;
        }
        
        return 1;
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        if(arr.length == 1) return answer;
        
        for(int i = 1; i < arr.length; i++) {
            answer = (answer*arr[i])/getGCD(answer, arr[i]);
        }
        
        return answer;
    }
}