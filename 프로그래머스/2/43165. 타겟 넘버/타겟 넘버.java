import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Deque<A> q = new ArrayDeque<>();
        q.offer(new A(0, numbers[0]));
        q.offer(new A(0, -numbers[0]));
        while(!q.isEmpty()) {
            A a = q.poll();
            if(a.index + 1 == numbers.length) {
                if(a.sum == target){
                    answer++;   
                }
            } else {
                q.offer(new A(a.index + 1, a.sum + numbers[a.index + 1]));
                q.offer(new A(a.index + 1, a.sum - numbers[a.index + 1]));
            }
        }
        
        return answer;
    }
}

class A {
    int index;
    int sum;
    
    public A(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }
}