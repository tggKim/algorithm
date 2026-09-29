class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 200000000;
        int right = 0;
        for(int num : stones) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for(int i = 0; i < stones.length; i++) {
                if(stones[i] < mid) {
                    count++;
                    if(count >= k) {
                        break;
                    }
                } else {
                    count = 0;
                }
            }
            
            if(count >= k) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
}