import java.util.*;
import java.io.*;

public class Main{
    
    static Vector<Vector<Integer>> vec = new Vector();
    static int[] arr; 
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        for(int i=0;i<=N;i++){
            vec.add(new Vector<Integer>());
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            vec.get(x).add(y);
        }
        
        bfs(X);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=1;i<arr.length;i++){
            if(i!=X && arr[i]==K){
                sb.append(i+"\n");
                count++;
            }
        }

        if(count==0){
            System.out.println("-1");
        }
        else{
            System.out.println(sb);
        }
    }
    
    static void bfs(int X){
        Queue<Integer> q = new LinkedList();
        q.add(X);
        while(!q.isEmpty()){
            int number = q.poll();
            for(int x : vec.get(number)){
                if(arr[x] == 0 && x != X){
                    arr[x] = arr[number] + 1;
                    q.add(x);
                }
            }
        }
    }
}