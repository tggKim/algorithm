import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while(Integer.parseInt(str=br.readLine())!=0){
            int num = Integer.parseInt(str);
            bw.write(num+" ");
            int x = num;
            while(x>=10){
                int mul=1;
                int y = x;
                while(y>0){
                    mul*=(y%10);
                    y/=10;
                }
                x=mul;
                bw.write(x+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}