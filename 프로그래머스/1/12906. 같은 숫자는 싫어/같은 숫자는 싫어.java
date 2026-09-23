import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int num : arr) {
            if(deque.isEmpty()) {
                deque.push(num);
            } else if(deque.peek() != num) {
                deque.push(num);
            }
        }
        
        int[] answer = new int[deque.size()];
        for(int i = answer.length - 1; i >= 0; i--) {
            answer[i] = deque.pop();
        }
        
        return answer;
    }
}