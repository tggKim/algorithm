import java.util.*;
import java.io.*;
public class Main{
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<Node>());
            arr[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken());
        int v2=Integer.parseInt(st.nextToken());
        int n1=method(1,v1);
        int n2=method(v1,v2);
        int n3=method(v2,N);
        int n4;
        if(n1==Integer.MAX_VALUE||n2==Integer.MAX_VALUE||n3==Integer.MAX_VALUE){
            n4=-1;
        }
        else{
            n4=n1+n2+n3;
        }
        int m1=method(1,v2);
        int m2=method(v2,v1);
        int m3=method(v1,N);
        int m4;
        if(m1==Integer.MAX_VALUE||m2==Integer.MAX_VALUE||m3==Integer.MAX_VALUE){
            m4=-1;
        }
        else{
            m4=m1+m2+m3;
        }
        if(n4==-1 && m4==-1){
            System.out.println(-1);
        }
        else if(n4==-1||m4==-1){
            System.out.println(Math.max(n4,m4));
        }
        else{
            System.out.println(Math.min(n4,m4));
        }
    }
    static int method(int start,int stop){
        for(int i=1;i<=N;i++){
            arr[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        arr[start]=0;
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node now=q.poll();
            visited[now.end]=true;
            if(arr[now.end]<now.weight){
                continue;
            }
            for(Node next:list.get(now.end)){
                if(!visited[next.end] && now.weight+next.weight<arr[next.end]){
                    arr[next.end]=now.weight+next.weight;
                    q.add(new Node(next.end,arr[next.end]));
                }
            }
        }
        return arr[stop];
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