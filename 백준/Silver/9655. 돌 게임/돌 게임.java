import java.util.*;
import java.io.*;
public class Main{
    static int[] dp = new int[1001];
    public static void main(String[] args)throws IOException{
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        dp[1]=1;
        dp[2]=0;
        dp[3]=1;
        for(int i=4;i<1001;i++){
            if(dp[i-1]==1&&dp[i-3]==1){
                dp[i]=0;
            }
            else{
                dp[i]=1;
            }
        }
        System.out.println(dp[N]==1?"SK":"CY");
    }
}