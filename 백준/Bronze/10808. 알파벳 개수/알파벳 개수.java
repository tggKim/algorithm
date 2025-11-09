import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[26];
        
        Scanner s = new Scanner(System.in);
        
        String str = s.next();
        
        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}