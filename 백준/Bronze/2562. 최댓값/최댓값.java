import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int number = 0;
        int max = 0;
        
        for(int i = 0; i < 9; i++) {
            int x = s.nextInt();
            
            if(x > max) {
                max = x;
                number = i + 1;
            }
        }
        
        System.out.print(max + "\n" + number);
    }
}