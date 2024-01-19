import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        Scanner s = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(s.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int x =(list.get(0)+list.get(3))-(list.get(1)+list.get(2));
        System.out.println(Math.abs(x));
    }
}