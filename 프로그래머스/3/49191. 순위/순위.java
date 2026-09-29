import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] flag = new boolean[n + 1][n + 1];
        for(int[] arr : results) {
            int a = arr[0];
            int b = arr[1];
            
            flag[a][b] = true;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(flag[i][k] && flag[k][j]) {
                        flag[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    continue;
                }
                
                if(flag[i][j] || flag[j][i]) {
                    count++;
                }
                
                if(count == n - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}