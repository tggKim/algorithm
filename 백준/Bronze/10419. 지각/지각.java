import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int num=Integer.parseInt(br.readLine());
            int answer=0;
            for(int j=0;j<=num;j++){
                if((j*j)+j<=num){
                    answer=j;
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
    }
}