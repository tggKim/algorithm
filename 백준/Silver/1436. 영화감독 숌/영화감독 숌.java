import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		long number = 0;
		long count = 0;
		while(count != N) {
			number++;
			String str = String.valueOf(number);
			if(str.contains("666")) {
				count++;
			}
		}
		
		System.out.println(number);
	}
}