import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(s.nextLine());
			int n = Integer.parseInt(s.nextLine());
			
			int[][] arr = new int[k + 1][n + 1];
            for(int x = 1; x < n + 1; x++) {
                arr[0][x] = x;
            }
            
			for(int x = 1; x < k + 1; x++) {
				for(int y = 1; y < n + 1; y++) {
					if(y == 1) {
						arr[x][y] = arr[x-1][y];
					} else {
						arr[x][y] = arr[x][y-1] + arr[x-1][y];
					}
				}
			}
			
			System.out.println(arr[k][n]);
		}
	}
}