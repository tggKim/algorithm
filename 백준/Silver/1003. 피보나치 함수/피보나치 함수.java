import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[] arr1 = new int[41];
		int[] arr2 = new int[41];
		
		arr1[0] = 1;
		arr2[1] = 1;
		for(int i = 2; i < 41; i++) {
			arr1[i] = arr1[i - 1] + arr1[i - 2];
			arr2[i] = arr2[i - 1] + arr2[i - 2];
		}
		
		int T = s.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int number = s.nextInt();
			
			sb.append(arr1[number] + " " + arr2[number] + "\n");
		}
		
		System.out.println(sb);
	}
}
