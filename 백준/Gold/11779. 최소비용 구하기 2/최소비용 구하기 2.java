import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] result = new int[n+1];
        int[] count = new int[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<Node>());
            result[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr.get(x).add(new Node(y,z));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        result[x]=0;
        q.add(new Node(x,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.end]=true;
            if(result[now.end]<now.weight){
                continue;
            }
            for(Node next : arr.get(now.end)){
                if(!visited[next.end] && now.weight+next.weight<result[next.end]){
                    result[next.end]=now.weight+next.weight;
                    count[next.end]=now.end;
                    q.add(new Node(next.end,result[next.end]));
                }
            }
        }
        System.out.println(result[y]);
        Stack<Integer> s = new Stack<>();
        s.push(y);
        while(count[y]!=0){
            s.push(count[y]);
            y=count[y];
        }
        System.out.println(s.size());
        while(!s.empty()){
            bw.write(s.pop()+" ");
        }
        bw.flush();
    }
    static class Node{
        int end;
        int weight;
        Node(int end,int weight){
            this.end=end;
            this.weight=weight;
        }
    }
}