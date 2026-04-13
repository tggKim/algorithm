import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		int count = 0;
		for(int i = list.size() - 1; i >= 0; i--) {
			int value = list.get(i);
			if(K >= value) {
				count += (K / value);
				K %= value;
			}
		}
		
		System.out.println(count);
	}
}