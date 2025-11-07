import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int N = s.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i = 0; i < N; i++) {
            sum1 += ((arr[i] / 30) + 1) * 10;
            sum2 += ((arr[i] / 60) + 1) * 15;
        }
        
        if(sum1 == sum2) {
            System.out.print("Y M " + sum1);
        } else if(sum1 < sum2) {
            System.out.print("Y " + sum1);
        } else {
            System.out.print("M " + sum2);
        }
    }
}