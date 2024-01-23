import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        while(num!=0){
            ArrayList<A> list = new ArrayList<>();
            for(int i=0;i<num;i++){
                String s = br.readLine();
                list.add(new A(s,s.toLowerCase()));
            }
            Collections.sort(list,(a,b)->a.str2.compareTo(b.str2));
            System.out.println(list.get(0).str1);
            num=Integer.parseInt(br.readLine());
        }
    }
    static class A{
        String str1;
        String str2;
        A(String str1,String str2){
            this.str1=str1;
            this.str2=str2;
        }
    }
}