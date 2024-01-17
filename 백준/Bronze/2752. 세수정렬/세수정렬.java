import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        ArrayList<Integer> list = new ArrayList();
        Scanner s = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(s.nextLine());
        for(int i=0;i<3;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        for(int i : list){
            System.out.print(i+" ");
        }
    }
}