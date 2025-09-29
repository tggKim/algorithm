import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] strs : clothes){
            if(map.containsKey(strs[1])){
                map.put(strs[1], map.get(strs[1]) + 1);
            } else {
                map.put(strs[1], 1);
            }
        }
        
        for(String key : map.keySet()){
            answer *= (map.get(key) + 1);
        }
        
        return answer - 1;
    }
}