import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        for(int i=1;i<=N;i++){
            int num=i;
            int x=0;
            while(num>0){
                x+=num%10;
                num/=10;
            }
            if(i%x==0){
                count++;
            }
        }
        System.out.println(count);
    }
}