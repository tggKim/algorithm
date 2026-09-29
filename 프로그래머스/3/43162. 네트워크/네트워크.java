import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;   
            }
        }
        
        return answer;
    }
    
    private void dfs(int number) {
        visited[number] = true;
        for(int i : list.get(number)) {
            if(!visited[i]){
                dfs(i);    
            }
        }
    }
}