import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> q = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            long x =Integer.parseInt(st.nextToken());
            q.add(x);
        }
        for(int i=0;i<m;i++){
            long a = q.poll();
            long b = q.poll();
            long num = a+b;
            q.add(num);
            q.add(num);
        }
        long count=0;
        while(!q.isEmpty()){
            count+=q.poll();
        }
        System.out.println(count);
    }
}