import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		long A = s.nextLong(); // 올라가고
		long B = s.nextLong(); // 내려가고
		long V = s.nextLong(); // 정상 높이
		
		long day = (V - B) / (A - B);
		if((V - B) % (A - B) != 0) {
			day++;
		}
		
		System.out.println(day);
	}
}