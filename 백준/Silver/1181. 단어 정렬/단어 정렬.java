import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		List<String> answer = list.stream()
			.distinct()
			.sorted((a1, a2) -> {
				return a1.length() == a2.length() ? a1.compareTo(a2) : a1.length() - a2.length();
			})
			.collect(Collectors.toList());
		
		for(int i = 0; i < answer.size(); i++) {
			bw.write(answer.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}