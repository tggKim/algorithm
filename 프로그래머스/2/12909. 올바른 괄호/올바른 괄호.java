import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                deque.addLast(s.charAt(i));
            } else {
                if(!deque.isEmpty() && deque.getLast() == '(') {
                    deque.removeLast();
                } else {
                    deque.addLast(s.charAt(i));
                }
            }
        }

        if(deque.isEmpty()){
            return true;
        } else {
            return false;
        }

    }
}