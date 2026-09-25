import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Long> pq = new PriorityQueue<>();
        for(long val : scoville) {
            pq.offer(val);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            
            pq.offer(num1 + num2 * 2);
            answer++;
        }
        
        if(pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}