import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str;
        while(Integer.parseInt(str=br.readLine())!=0){
            if(Integer.parseInt(str)%n==0){
                bw.write(Integer.parseInt(str)+" is a multiple of "+n+".\n");                
            }
            else{
                bw.write(Integer.parseInt(str)+" is NOT a multiple of "+n+".\n");  
            }
        }
        bw.flush();
    }
}