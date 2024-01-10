import java.io.IOException;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int x=0;
        int y=0;
        char c;
        if(str.charAt(0)=='0'){
            c='0';
            x++;
        }
        else{
            c='1';
            y++;
        }
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=c){
                if(str.charAt(i)=='0'){
                    c='0';
                    x++;
                }
                else{
                    c='1';
                    y++;
                }
            }
        }
        System.out.println(Math.min(x,y));
    }
}