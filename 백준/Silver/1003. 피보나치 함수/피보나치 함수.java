import java.util.*;
public class Main {
	static int[][] arr = new int[41][2];
	static boolean[] visited = new boolean[41];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		dp(40);
		
		int T = s.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int number = s.nextInt();
			
			sb.append(arr[number][0] + " " + arr[number][1] + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void dp(int number) {
		if(visited[number]) {
			return;
		}
		
		if(number == 0) {
			arr[0][0] = 1;
			arr[0][1] = 0;
			visited[number] = true;
			return;
		} else if(number == 1) {
			arr[1][0] = 0;
			arr[1][1] = 1;
			visited[number] = true;
			return;
		}
		
		dp(number - 1);
		dp(number - 2);
		
		arr[number][0] = arr[number - 1][0] + arr[number - 2][0];
		arr[number][1] = arr[number - 1][1] + arr[number - 2][1];
		visited[number] = true;
	}
}