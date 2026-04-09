import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner s = new Scanner(System.in);
		
		int M = s.nextInt();
		int N = s.nextInt();
		
		boolean[] arr = new boolean[1000001];
        arr[1] = true;
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] == false) {
				for(int j = i + i; j < arr.length; j+=i) {
					arr[j] = true;
				}
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(!arr[i]) {
				bw.write(i + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}