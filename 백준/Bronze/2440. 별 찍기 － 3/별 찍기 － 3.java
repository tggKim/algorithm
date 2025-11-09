import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int N = s.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = N; j >= i; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}