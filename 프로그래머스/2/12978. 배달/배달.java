import java.util.*;
class Solution {
    
    int[] time;
    List<List<Node>> list;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        time = new int[N+1]; 
        
        for(int i=0;i<time.length;i++){
            time[i] = Integer.MAX_VALUE;
        }

        list = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<Node>());
        }
        for(int i=0;i<road.length;i++){
            list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
        
        dijkstra();
        
        for(int i=1;i<time.length;i++){
            System.out.print(time[i] + " ");
            if(time[i] <= K){
                answer++;
            }
        }

        return answer;
    }
    
    void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.weight, b.weight)
        );
        q.add(new Node(1,0));
        
        time[1] = 0; 
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            if(time[node.number] < node.weight){
                continue;
            }
            
            for(Node nextNode : list.get(node.number)){
                if(time[nextNode.number] > node.weight + nextNode.weight){
                    time[nextNode.number] = node.weight + nextNode.weight;
                    q.add(new Node(nextNode.number, time[nextNode.number]));
                }
            }
        }
    }
}

class Node{
    int number;
    int weight;
    public Node(int number, int weight){
        this.number = number;
        this.weight = weight;
    }
}