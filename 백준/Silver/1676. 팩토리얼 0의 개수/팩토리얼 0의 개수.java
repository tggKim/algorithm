import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		int count = 0;
		
		while(N >= 5) {
			count += (N / 5);
			N /= 5;
		}
		
		System.out.println(count);
	}
}