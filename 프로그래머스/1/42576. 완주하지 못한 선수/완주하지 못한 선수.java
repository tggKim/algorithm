import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String user: participant) {
            if(map.get(user) != null) {
                map.put(user, map.get(user) + 1);        
            } else {
                map.put(user, 1);
            }
        }
                        
        for(String user: completion) {
            if(map.get(user) > 1) {
                map.put(user, map.get(user) - 1);
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