class Solution {
    public int solution(int n) {
       int count = Integer.bitCount(n);
        
        while(true) {
            if(Integer.bitCount(++n) == count) return n;
        }
    }
}