import java.util.*;
import java.io.*;
public class Main{
    static int[][] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i!=j){
                    arr[i][j]=999999;
                }
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
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
        int[] list = new int[N+1];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            int sum=0;
            for(int j=1;j<=N;j++){
                sum+=arr[i][j];
            }
            list[i]=sum;
            min = Math.min(min,sum);
        }
        for(int i=1;i<=N;i++){
            if(min==list[i]){
                System.out.print(i);
                break;
            }
        }
    }
}