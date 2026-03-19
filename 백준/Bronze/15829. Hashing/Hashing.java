import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int L = s.nextInt();
        s.nextLine();
		String str = s.nextLine();
		
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			int num1 = (str.charAt(i) - 'a') + 1;
			int num2 = (int)Math.pow(31, i);
			sum += num1 * num2;
		}
		
		sum %= 1234567891;
		
		System.out.println(sum);
	}
}