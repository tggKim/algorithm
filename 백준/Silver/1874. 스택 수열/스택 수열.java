import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> s = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(number >= count) {
				while(count <= number) {
					s.push(count++);
					sb.append("+\n");
				}
				s.pop();
				sb.append("-\n");
			} else if(!s.isEmpty() && number == s.peek()) {
                s.pop();
				sb.append("-\n");
			} else {
                System.out.println("NO");
                return;
            }
		}
		
		System.out.println(sb);
	}
}