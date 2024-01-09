import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            long answer=0;
            long max = arr[arr.length-1];
            for(int j=arr.length-2;j>=0;j--){
                if(arr[j]>=max){
                    max=arr[j];
                }
                else{
                    answer+=(max-arr[j]);
                }
            }
            System.out.println(answer);
        }
    }
}