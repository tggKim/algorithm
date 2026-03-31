import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] strs = new String[3];
		
		strs[0] = s.nextLine();
		strs[1] = s.nextLine();
		strs[2] = s.nextLine();
		
		for(int i = 0; i < 3; i++) {
			if(!strs[i].equals("FizzBuzz") && !strs[i].equals("Fizz") && !strs[i].equals("Buzz")) {
				String answer = method(Integer.parseInt(strs[i]) + (3 - i));
				System.out.println(answer);
				break;
			}
		}
		
	}
	
	public static String method(int num) {
		if(num % 3 == 0 && num % 5 == 0) {
			return "FizzBuzz";
		} else if(num % 3 == 0) {
			return "Fizz";
		} else if(num % 5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(num);
		}
	}
}