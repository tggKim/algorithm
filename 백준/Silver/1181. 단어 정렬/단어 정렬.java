import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(!list.contains(str)){
                list.add(str);   
            }
		}
		
		Collections.sort(list, (a1, a2) -> {
			if(a1.length() != a2.length()) {
				return a1.length() - a2.length();
			} else {
				return a1.compareTo(a2);
			}
		});
		
		for(int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}