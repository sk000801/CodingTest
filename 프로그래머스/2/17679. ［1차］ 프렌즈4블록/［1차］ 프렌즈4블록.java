//30분 ..? 빈칸을 나타내는 flag를 있는 문자로 두어 개수가 안맞았다ㅋ
import java.util.*;
class Solution {
    //지워졌을 때 E와 같은 문자 넣으면 좋을 듯
    public boolean hasBlock(int m, int n, String[][] board) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = 0;
                String s = board[i][j];
                if(s.equals(".")) continue;
                if(i+1 >= m || j+1 >= n) continue;
                if(board[i+1][j].equals(s)) count++;
                if(board[i][j+1].equals(s)) count++;
                if(board[i+1][j+1].equals(s)) count++;
                if(count == 3) return true;
            }
        }
        return false;
    }
    
    public int solution(int m, int n, String[] board) {
        String[][] board2 = new String[m][n];
        for(int i = 0; i < m; i++) {
            board2[i] = board[i].split("");
        }
        
        while(hasBlock(m, n, board2)) {
            Set<int[]> set = new HashSet<>();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    int count = 0;
                    String s = board2[i][j];
                    if(s.equals(".")) continue;
                    if(i+1 >= m || j+1 >= n) continue;
                    if(board2[i+1][j].equals(s)) count++;
                    if(board2[i][j+1].equals(s)) count++;
                    if(board2[i+1][j+1].equals(s)) count++;
                    if(count == 3) {
                        set.add(new int[]{i+1, j});
                        set.add(new int[]{i, j+1});
                        set.add(new int[]{i, j});
                        set.add(new int[]{i+1, j+1});
                    }
                }
            }
            
            List<int[]> list = new ArrayList<>(set);
            for(int[] arr : list) {
                board2[arr[0]][arr[1]] = ".";
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = m-1; j >= 0; j--) {
                    if(board2[j][i].equals(".")) {
                        for(int r = j-1; r >= 0; r--) {
                            if(!board2[r][i].equals(".")) {
                                board2[j][i] = board2[r][i];
                                board2[r][i] = ".";
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(board2[i][j].equals(".")) answer++;
            }
        }
            
        return answer;
    }
}