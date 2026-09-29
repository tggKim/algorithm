import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        int[] count = new int[n + 1];
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];

            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int num = q.poll();
            for(int i : list.get(num)) {
                if(!visited[i]) {
                    visited[i] = true;
                    count[i] = count[num] + 1;
                    q.offer(i);
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        
        int answer = 0;
        for(int i = 2; i < count.length; i++) {
            if(count[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}