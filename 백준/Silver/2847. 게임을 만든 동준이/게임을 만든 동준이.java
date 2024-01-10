import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int max=arr[N-1];
        int count=0;
        for(int i=N-2;i>=0;i--){
            if(arr[i]>=max){
                count+=(arr[i]-max+1);
                max-=1;
            }
            else{
                max=arr[i];
            }
        }
        System.out.println(count);
    }
}