import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : reserve) {
            set1.add(num);
        }
        
        Set<Integer> set2 = new HashSet<>();
        for(int num : lost) {
            if(set1.contains(num)) {
                set1.remove(num);
            } else {
                set2.add(num);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(Integer num : set2) {
            list.add(num);
        }
        Collections.sort(list);
        
        int count = 0;
        for(int num : list) {
            if(set1.contains(num - 1)) {
                count++;
                set1.remove(num - 1);
                continue;
            }
            
            if(set1.contains(num + 1)) {
                count++;
                set1.remove(num + 1);
            }
        }
        
        return count + n - set2.size();
    }
}