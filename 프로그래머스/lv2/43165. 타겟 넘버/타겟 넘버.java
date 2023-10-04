//11분
class Solution {
    int answer = 0;
    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length) { 
            if(target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]); 
            dfs(numbers, depth + 1, target, sum - numbers[depth]); 
        }
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
}