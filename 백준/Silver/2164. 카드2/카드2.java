import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        int N = s.nextInt();
        for(int i = 0; i < N; i++) {
            queue.addLast(i + 1);
        }

        while(queue.size() > 1) {
            queue.removeFirst();
            queue.addLast(queue.removeFirst());
        }

        System.out.println(queue.removeFirst());
    }
}