import java.util.*;
import java.io.*;

public class Main{
    
    static final int INF = 987654321;
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[V][V];
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                arr[i][j]=INF;
            }
        }
        
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a-1][b-1]=c;
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                for(int k=0;k<V;k++){
                    if(j==k){
                        arr[j][k]=0;
                        continue;
                    }
                    if(arr[j][k] > arr[j][i] + arr[i][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }
        
        int answer = INF;
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i==j){
                    continue;
                }
                
                if(arr[i][j] != INF && arr[j][i] != INF){
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }
        
        if(answer == INF){
            System.out.println(-1);
        } 
        else{
            System.out.println(answer);    
        }
    }
}