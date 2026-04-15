import java.util.*;
import java.io.*;
public class Main {
	static int[] dp;
	static int[] arr; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		arr = new int[N + 1];

        for(int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
		
		if(N == 1) {
			System.out.println(arr[1]);
			return;
		} else if(N == 2) {
			System.out.println(arr[1] + arr[2]);
			return;
		}
		
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		
		System.out.println(dp(N));
	}
	
	static int dp(int number) {
		if(number == 0) {
			return 0;
		}
		
		if(dp[number] > 0) {
			return dp[number];
		}
		
		dp[number] = Math.max(dp(number - 2) + arr[number], dp(number - 3) + arr[number - 1] + arr[number]);
		
		return dp[number];
	}
}