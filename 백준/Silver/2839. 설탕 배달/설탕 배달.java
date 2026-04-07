import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		int count = 0;
		while(N >= 0) {
			if(N % 5 == 0) {
				count += (N / 5);
				System.out.println(count);
				return;
			}
			
			N -= 3;
			count++;
		}
		
		System.out.println(-1);
	}
	
}