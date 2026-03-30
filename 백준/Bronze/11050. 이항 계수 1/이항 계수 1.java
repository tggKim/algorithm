import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		int num = N - K;
		
		int answer = method(N) / (method(K) * method(num));
		
		System.out.println(answer);
	}
	
	public static int method(int number) {
		int mul = 1;
		for(int i = number; i > 0; i--) {
			mul *= i;
		}
		return mul;
	}
}