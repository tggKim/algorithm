import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < 7; i++) {
            int number = s.nextInt();
            if(number % 2 != 0) {
                sum += number;
                min = Math.min(min, number); 
            }
        }
        
        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.print(sum + "\n" + min);   
        }
    }
}