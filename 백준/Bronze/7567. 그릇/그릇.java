import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int num=10;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                num+=10;
            }
            else{
                num+=5;
            }
        }
        System.out.println(num);
    }
}