import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list2.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list1);
        Collections.sort(list2,(a,b)->b-a);
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=(list1.get(i)*list2.get(i));
        }
        System.out.println(sum);
    }
}