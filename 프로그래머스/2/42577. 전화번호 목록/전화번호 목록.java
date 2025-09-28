import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> set = new HashSet<>();
        
        for(String str : phone_book){
            
            for(int i=0;i<str.length();i++){
                String str2 = str.substring(0,i+1);
                if(set.contains(str2)){
                    return false;
                }
            }
            
            set.add(str);
        }
        
        set = new HashSet<>();
        
        for(int i=phone_book.length-1;i>=0;i--){
            
            String str = phone_book[i];
            
            for(int j=0;j<str.length();j++){
                String str2 = str.substring(0,j+1);
                if(set.contains(str2)){
                    return false;
                }
            }
            
            set.add(str);
        }
        
        return true;
    }
}