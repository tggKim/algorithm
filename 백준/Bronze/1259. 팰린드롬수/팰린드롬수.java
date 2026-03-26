import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			
			String reversed = new StringBuilder(str).reverse().toString();
			
			if(str.equals(reversed)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}