import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[] arr = new int[1000001];
		for(int i = 2; i < arr.length; i++) {
			int min = arr[i - 1];
			
			if(i % 2 == 0) {
				min = Math.min(min, arr[i / 2]);
			}
			
			if(i % 3 == 0) {
				min = Math.min(min, arr[i / 3]);
			}

			arr[i] = min + 1;
		}
		
		int N = s.nextInt();
		
		System.out.println(arr[N]);
	}
}