import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        
        if(A == B && B == C) {
            System.out.print(10000 + A * 1000);
        } else if(A == B) {
            System.out.print(1000 + A * 100);
        } else if(B == C) {
            System.out.print(1000 + B * 100);
        } else if(A == C) {
            System.out.print(1000 + A * 100);
        } else {
            int number = Math.max(A, Math.max(B, C));
            System.out.print(number * 100);
        }
    }
}