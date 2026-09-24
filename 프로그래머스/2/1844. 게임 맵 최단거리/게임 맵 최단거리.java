import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] calx = {1, -1, 0, 0};
        int[] caly = {0, 0, 1, -1};
        
        Deque<A> q = new ArrayDeque<>();
        q.offer(new A(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            A a = q.poll();
            int x = a.x;
            int y = a.y;
            for(int i = 0; i < 4; i++) {
                int dx = x + calx[i];
                int dy = y + caly[i];
                if(dx == maps.length - 1 && dy == maps[0].length - 1){
                    return a.count + 1;
                }
                
                if(dx >= 0 && dx < maps.length && dy >= 0 && dy < maps[0].length && maps[dx][dy] == 1 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    q.offer(new A(dx, dy, a.count + 1));
                }
            }
        }
        
        return -1;
    }
}

class A {
    int count;
    int x;
    int y;
    public A(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}