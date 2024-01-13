import java.util.*;
import java.io.*;
public class Main{
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V+1];
        int[] result = new int[V+1];
        for(int i=0;i<=V;i++){
            arr.add(new ArrayList<Node>());
            result[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Node(v,w));
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        result[K]=0;
        q.add(new Node(K,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.end]=true;
            for(Node next : arr.get(now.end)){
                if(!visited[next.end] && now.weight+ next.weight<result[next.end]){
                    result[next.end]=now.weight+next.weight;
                    q.add(new Node(next.end,result[next.end]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(result[i]==Integer.MAX_VALUE){
                bw.write("INF\n");
            }
            else{
                bw.write(result[i]+"\n");
            }
        }
        bw.flush();
    }
    static class Node{
        int weight;
        int end;
        public Node(int end,int weight){
            this.end=end;
            this.weight=weight;
        }
    }
}