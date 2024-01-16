import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = s.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='.'){
                if(count>0 && count%2==0){
                    int num=count;
                    while(num>2){
                        bw.write("AAAA");
                        num-=4;
                    }
                    if(num>0){
                        bw.write("BB");
                    }
                }
                else if(count>0 && count%2!=0){
                    System.out.println(-1);
                    return;
                }
                bw.write(".");
                count=0;
            }
            else{
                count++;
            }
        }
        int num=count;
        if(count%2!=0){
            System.out.println(-1);
            return;
        }
        while(num>2){
            bw.write("AAAA");
            num-=4;
        }
        if(num>0){
            bw.write("BB");
        }
        bw.flush();
    }
}