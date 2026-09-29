class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1;
        long right = 0;
        for(long time : times) {
            right = Math.max(right, time);
        }
        
        right *= n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            long sum = 0;
            for(long time : times) {
                sum += mid / time;
            }
            
            if(sum >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}