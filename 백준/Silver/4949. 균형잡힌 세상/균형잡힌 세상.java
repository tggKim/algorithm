import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		while(!str.equals(".")) {
			Deque<Character> s = new ArrayDeque<>();
			boolean flag = true;
			for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                
				if(c == '(' || c == '[') {
					s.addLast(c);
				} else if(c == ')' || c == ']') {
					if(s.isEmpty()) {
						flag = false;
						break;
					} else {
						if(c == ')' && s.getLast() != '(') {
							flag = false;
							break;
						} else if(c == ']' && s.getLast() != '[') {
							flag = false;
							break;
						} else {
                            s.removeLast();
                        }
					}
				}
			}
			
			if(flag && s.isEmpty()) {
				bw.write("yes\n");
			} else {
                bw.write("no\n");
            }
            str = br.readLine();
		}
		
		bw.flush();
		bw.close();
	}
	
}