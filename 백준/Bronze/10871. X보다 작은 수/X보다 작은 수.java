import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            int number = Integer.parseInt(st.nextToken());
            if(number < X) {
                sb.append(number + " ");
            }
        }
        
        System.out.println(sb.toString());
    }
}