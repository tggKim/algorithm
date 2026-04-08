import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> s = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String flag = st.nextToken();
			
			if(flag.equals("push")) {
				Integer num = Integer.parseInt(st.nextToken());
				s.addLast(num);
			} else if(flag.equals("pop")) {
				if(s.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(s.getFirst() + "\n");
					s.removeFirst();
				}
			} else if(flag.equals("size")) {
				bw.write(s.size() + "\n");
			} else if(flag.equals("empty")) {
				if(s.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if(flag.equals("front")) {
				if(s.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(s.getFirst() + "\n");
				} 
			} else if(flag.equals("back")) {
				if(s.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(s.getLast() + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}