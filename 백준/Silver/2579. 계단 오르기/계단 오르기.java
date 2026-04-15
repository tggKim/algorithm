import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] answer = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

        if(N == 1) {
            System.out.println(arr[1]);
            return;
        } else if(N == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }
		
		answer[1] = arr[1];
		answer[2] = arr[1] + arr[2];
		
		for(int i = 3; i < N + 1; i++) {
			answer[i] = Math.max(answer[i - 2] + arr[i], answer[i-3] + arr[i-1] + arr[i]);
		}
		
		System.out.println(answer[N]);
	}
}