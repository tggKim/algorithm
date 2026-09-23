import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        int answer = nums.length / 2;
        if(answer > set.size()) {
            return set.size();
        }
        
        return answer;
    }
}