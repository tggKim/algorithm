import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		Arrays.sort(arr, (arr1, arr2) -> {
			if(arr1[1] != arr2[1]) {
				return arr1[1] - arr2[1];
			} else {
				return arr1[0] - arr2[0];
			}
		});
		
		for(int[] answers : arr) {
			bw.write(answers[0] + " " + answers[1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}