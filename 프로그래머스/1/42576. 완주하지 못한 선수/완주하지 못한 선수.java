import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String user: participant) {
            map.merge(user, 1, Integer::sum);
        }
                        
        for(String user: completion) {
            if(map.get(user) > 1) {
                map.merge(user, -1, Integer::sum);
            } else {
                map.remove(user);
            }
        }
                        
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            return entry.getKey();
        }
                        
        return null;
    }
}