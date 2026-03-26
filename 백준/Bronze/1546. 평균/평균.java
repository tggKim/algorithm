import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		s.nextLine();
		StringTokenizer st = new StringTokenizer(s.nextLine());
		
		double[] arr = new double[N];
		double max = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += (arr[i] / max * 100);
		}
		
		System.out.println(sum / N);
	}
}