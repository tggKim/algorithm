import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        
        List<Integer> list = List.of(A, B, C);
        
        list.stream()
            .sorted((a, b) -> a - b)
            .forEach(number -> System.out.print(number + " "));
    }
}