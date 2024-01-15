import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int num=1;
            for(int j=0;j<b;j++){
                num*=a;
                num%=10;
            }
            if(num==0){
                bw.write("10\n");
            }
            else{
                bw.write(num+"\n");
            }
        }
        bw.flush();
    }
}