import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			Deque<Character> s = new ArrayDeque<>();
			
			boolean flag = true;
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				if(c == '(') {
					s.addLast(c);
				} else {
					if(s.isEmpty()) {
						flag = false;
						break;
					} else if(s.getLast() != '(') {
						flag = false;
						break;
					} else {
						s.removeLast();
					}
				}
			}
			
			if(flag && s.isEmpty()) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}