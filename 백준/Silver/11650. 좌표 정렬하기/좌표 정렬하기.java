import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Point[] arr = new Point[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i] = new Point(x, y);
		}
		
		Arrays.sort(arr, (point1, point2) -> {
			if(point1.x != point2.x) {
				return point1.x - point2.x;
			} else {
				return point1.y - point2.y;
			}
		});
		
		for(Point point : arr) {
			bw.write(point.x + " " + point.y + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}