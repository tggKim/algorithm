import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        
        List<Time> list = new ArrayList<>();
        
        for(int i=0;i<book_time.length;i++){
            int startTime = Integer.parseInt(book_time[i][0].replace(":",""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":",""));
            endTime+=10;
            if(endTime%100>=60){
                endTime+=40;
            }
            Time time = new Time(startTime, endTime);
            list.add(time);
        }
        
        Collections.sort(list,(a,b) -> {
            if(a.start==b.start){
                return a.end-b.end;
            }
            else{
                return a.start-b.start;
            }
        });
        
        List<Integer> room = new ArrayList<>();
        
        for(int i=0;i<list.size();i++){
            //Collections.sort(room);
            
            Time time = list.get(i);
            
            boolean b = false;
            
            for(int j=0;j<room.size();j++){
                if(time.start>=room.get(j)){
                    room.set(j,time.end);
                    b=true;
                    break;
                }    
            }
            
            if(!b){
                room.add(time.end);
            }
        }
        
        return room.size();
    }
}

class Time{
    int start;
    int end;
    public Time(int start, int end){
        this.start = start;
        this.end = end;
    }
}