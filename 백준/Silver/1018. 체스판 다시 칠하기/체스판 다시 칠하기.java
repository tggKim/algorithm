import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				for(int k = 0; k < 2; k++) {
					int count = 0;
					char c = k % 2 == 0 ? 'W' : 'B';
					
					for(int x = i; x < i + 8; x++) {
						for(int y = j; y < j + 8; y++) {
							if(x % 2 == 0 && y % 2 == 0 && arr[x][y] != c) {
								count++;
							} else if (x % 2 == 0 && y % 2 != 0 && arr[x][y] == c) {
								count++;
							} else if (x % 2 != 0 && y % 2 == 0 && arr[x][y] == c) {
								count++;
							} else if (x % 2 != 0 && y % 2 != 0 && arr[x][y] != c) {
								count++;
							}
						}
					}
					
					min = Math.min(min, count);
				}
			}
		}
		
		System.out.println(min);
	}
}