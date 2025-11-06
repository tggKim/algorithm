import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int[] arr = new int[9];
        
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if((sum - (arr[i] + arr[j])) == 100) {
                    for(int x = 0; x < 9; x++) {
                        if(x != i && x != j) {
                            System.out.println(arr[x]);
                        }
                    }
                    return;
                }
            }
        }
    }
}