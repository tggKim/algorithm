import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer=0;
        for(int i=0;i<N;i++){
            answer+=Integer.parseInt(st.nextToken());
        }
        answer+=((N-1)*8);
        System.out.println(answer/24+" "+answer%24);
    }
}