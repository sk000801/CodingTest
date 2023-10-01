class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++) {
                for(int r = 0; r < arr1[0].length; r++) {
                    answer[i][j] += arr1[i][r]*arr2[r][j];
                }
            }
        }
        return answer;
    }
}