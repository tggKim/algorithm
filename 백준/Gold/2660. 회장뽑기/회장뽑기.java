import java.util.*;
import java.io.*;
public class Main{
    static int[][] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i!=j){
                    arr[i][j]=100;
                }
            }
        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x==-1&&y==-1){
                break;
            }
            arr[x][y]=1;
            arr[y][x]=1;
        }
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(arr[i][j]>arr[i][k]+arr[k][j]){
                        arr[i][j]=arr[i][k]+arr[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int[] list = new int[N+1];
        for(int i=1;i<=N;i++){
            int max=0;
            for(int j=1;j<=N;j++){
                if(arr[i][j]!=100){
                    max=Math.max(max,arr[i][j]);
                }
            }
            list[i]=max;
            min = Math.min(min,max);
        }
        int count=0;
        for(int i=1;i<=N;i++){
            if(list[i]==min){
                count++;
            }
        }
        bw.write(min+" "+count+"\n");
        for(int i=1;i<=N;i++){
            if(list[i]==min){
                bw.write(i+" ");
            }
        }
        bw.flush();
    }
}