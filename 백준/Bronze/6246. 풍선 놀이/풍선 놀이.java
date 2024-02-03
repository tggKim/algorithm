import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j=a;j<=N;j+=b){
                arr[j]=1;
            }
        }
        int count=0;
        for(int i=1;i<=N;i++){
            if(arr[i]==0){
                count++;
            }
        }
        System.out.println(count);
    }
}