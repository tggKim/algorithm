import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		Deque<Integer> s = new ArrayDeque<>();
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				s.removeLast();
			} else {
				s.addLast(num);
			}
		}
		
		int sum = 0;
		while(!s.isEmpty()) {
			sum += s.removeLast();
		}
		
		System.out.println(sum);
	}
}