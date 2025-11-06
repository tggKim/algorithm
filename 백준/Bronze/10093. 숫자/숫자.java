import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        long a = s.nextLong();
        long b = s.nextLong();
        
        long max = (a >= b ? a : b);
        long min = (a >= b ? b : a);
        
        if(max == min) {
            System.out.print(0);
            return;
        }
            
        System.out.println(max - min - 1);
        StringBuilder sb = new StringBuilder();
        for(long i = min + 1; i < max; i++) {
            sb.append(i + " ");
        }
        System.out.print(sb.toString());
    }
}