import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		int num = (int)Math.round(n * 0.15);
		
		double sum = 0;
		for(int i = num; i < n - num; i++) {
			sum += list.get(i);
		}
		
		sum /= (n - num * 2);
		
		System.out.println(Math.round(sum));
	}
}