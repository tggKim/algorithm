import java.util.*;
import java.io.*;

public class Main {
    
    static char[][] arr;
    static boolean[][] visited;
    static int[] calx = {0,0,1,-1};
    static int[] caly = {1,-1,0,0};
    static Deque<Point> q = new ArrayDeque<>();
	static List<Integer> list = new ArrayList<>();
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        arr = new char[R][C];
        visited = new boolean[R][C];
        
        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                arr[i][j] = str.charAt(j);
                if(str.charAt(j) == 'F') {
                    q.addLast(new Point(i, j, 'F', 0));
                }
            }
        }
  
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(arr[i][j] == 'J') {
                    q.addLast(new Point(i, j, 'J', 0));
                }
            }
        }
        
        bfs();

        if(list.isEmpty()){
            System.out.println("IMPOSSIBLE");
        }
        else{
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }
    
    static void bfs() {
        while(!q.isEmpty()) {
            Point p = q.removeFirst();
            int x = p.x;
            int y = p.y;
			char c = p.c;
            int count = p.count;
            
            for(int i=0;i<4;i++) {
                
                int cx = x + calx[i];
                int cy = y + caly[i];
                
                if(c == 'J' && (cx < 0 || cx >= arr.length || cy < 0 || cy >= arr[0].length)) {
                    list.add(count+1);
                }
                
                if(cx >= 0 && cx < arr.length && cy >= 0 && cy < arr[0].length) {
                    if(c == 'J' && arr[cx][cy] == '.') {
                        arr[cx][cy] = 'J';
                        Point addPoint = new Point(cx, cy, 'J', count + 1);
                        q.addLast(addPoint);
                    } else if(c == 'F' && (arr[cx][cy] == '.' || arr[cx][cy] == 'J')) {
                        arr[cx][cy] = 'F';
                        q.addLast(new Point(cx, cy, 'F', 0));
                    }    
                }
               
            }
        }
    }
    
    static class Point {
        int x;
        int y;
		char c;
        int count;
        
        public Point (int x, int y, char c, int count) {
            this.x = x;
            this.y = y;
			this.c = c;
            this.count = count;
        }
    }
    
}