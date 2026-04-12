import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(String.valueOf(i + 1), str);
            map.put(str, String.valueOf(i + 1));
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            bw.write(map.get(str) + "\n");
        }

        bw.flush();
        bw.close();
    }
}