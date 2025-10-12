import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Progress> deque = new ArrayDeque<>();
        
        // deque 에 작업 추가
        for(int i = 0; i < progresses.length; i++) {
            deque.addLast(new Progress(progresses[i], speeds[i]));
        }
        
        // 모든작업 완료까지 무한 반복
        int day = 0;
        List<Integer> answerList = new ArrayList<>();
        while(!deque.isEmpty()) {
            
            day++;
            
            int size = deque.size();
            
            for(int i = 0; i < size; i++) {
                Progress p = deque.removeFirst();
                if(p.progress < 100) {
                    p.progress += p.speeds;
                }
                deque.addLast(p);
            }

            int count=0;
            while(!deque.isEmpty() && deque.getFirst().progress >= 100) {
                count++;
                deque.removeFirst();
            }
            
            if(count != 0) {
                answerList.add(count);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
            
    }
    
    class Progress{
        int progress;
        int speeds;
        
        public Progress(int progress, int speeds){
            this.progress = progress;
            this.speeds = speeds;
        }
    }
    
}