// 크기 n 도넛 = n개의 정점 + n개의 간선
// n-1 개의 정점을 한번씩 방문하고 돌아오면 원래 출발했던 정점으로 돌아옴
// 크기 n 막대 = n개의 정점 + n-1 개의 간선
// n-1개의 정점을 한번씩 방문하게 되는 정점이 단 하나
// 크기 n 팔자 = 2n+1 개의 정점 2n+2 개의 간선
// 실은 생성점 = 들 0 나 2
// 막대는 들어오는 간선 수 하나 이상
// 8자는 들어오고 나가는 간선 수 모두 둘 이상
// 도넛은 나머지^_^
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int[][] edge = new int[1_000_001][2]; //0 주고 1 받음
        for(int i = 0; i < edges.length; i++) {
            int[] cur = edges[i];
            edge[cur[0]][0]++;
            edge[cur[1]][1]++;
        }
        
        for(int i = 1; i <= 1_000_000; i++) {
            if(edge[i][0] >= 2 && edge[i][1] == 0) {
                answer[0] = i;
            } else if(edge[i][0] >= 2 && edge[i][1] >= 2) { //8자
                answer[3]++;
            } else if(edge[i][1] > 0 && edge[i][0] == 0) { //막대
                answer[2]++;
            }
        }
        
        answer[1] = edge[answer[0]][0]-answer[2]-answer[3];
        return answer;
    }
}