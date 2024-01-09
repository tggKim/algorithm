import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list);
        int max=0;
        for(int i=0;i<list.size();i++){
            int num = (list.size()-i)*list.get(i);
            if(max<num){
                max=num;
            }
        }
        System.out.println(max);
    }
}