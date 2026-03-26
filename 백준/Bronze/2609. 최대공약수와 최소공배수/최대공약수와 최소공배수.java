import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt();
		int b = s.nextInt();
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		int x = max;
		int y = min;
		int r = max % min;
		while(r != 0) {
			x = y;
			y = r;
			r = x % y;
		}
		
		System.out.println(y);
		System.out.println(a * b / y);
	}
}