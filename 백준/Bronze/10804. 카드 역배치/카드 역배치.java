import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int[] arr = new int[21];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for(int i = 0; i < 10; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int range = (b - a + 1) / 2;
            
            int count = 0;
            for(int j = a; j < a + range; j++) {
                int temp = arr[j];
                arr[j] = arr[b - count];
                arr[b - count] = temp;
                count++;
            }
        }
        
        for(int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}