import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		int flag = 0;
		int sum = 0;
		for(int i = 1; i <= str.length() - 1; i++) {
			int calNum;
			if(i % 2 != 0) {
				calNum = 1;
			} else {
				calNum = 3;
			}
			
			if(str.charAt(i - 1) == '*'){
				flag = calNum;
			} else {
				int num = str.charAt(i - 1) - '0';
				sum += num * calNum;
			}
		}
		
		sum += (str.charAt(str.length() - 1) - '0');
		
		if(sum % 10 == 0) {
			System.out.println(0);
		} else {
			for(int i = 1; i <= 9; i++) {
				if((sum + i * flag) % 10 == 0) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}