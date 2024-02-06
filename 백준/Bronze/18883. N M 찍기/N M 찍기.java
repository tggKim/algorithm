import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(j==M-1){
                    bw.write(count+"\n");
                    count++;
                }
                else{
                    bw.write(count+" ");
                    count++;
                }
            }
        }
        bw.flush();
    }
}