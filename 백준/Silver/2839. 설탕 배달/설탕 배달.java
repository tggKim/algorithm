import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		if(N % 5 == 0) {
			System.out.println(N / 5);
			return;
		} 
		
		int count = 0;
		while(true) {
			if(N % 5 == 0) {
				break;
			}
            
			N -= 3;
			if(N < 0) {
				System.out.println(-1);
				return;
			}
			count++;
		}
		
		count += (N / 5);
		
		System.out.println(count);
	}
}