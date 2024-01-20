import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] arr = new int[N+1];
        boolean[] visited = new boolean[N+1];
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<Node>());
            arr[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        arr[X]=0;
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        q.add(new Node(X,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.end]=true;
            if(arr[now.end]<now.weight){
                continue;
            }
            for(Node next : list.get(now.end)){
                if(!visited[next.end] && now.weight+ next.weight<arr[next.end]){
                    arr[next.end]=now.weight+next.weight;
                    q.add(new Node(next.end,arr[next.end]));
                }
            }
        }
        System.out.println(arr[Y]);
    }
    static class Node{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end=end;
            this.weight=weight;
        }
    }
}