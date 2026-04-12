import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> s = new HashSet<>();
        
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int number = 0;
            if(!str.equals("all") && !str.equals("empty")) {
                 number = Integer.parseInt(st.nextToken());
            }

            if(str.equals("add")) {
                s.add(number);
            } else if(str.equals("remove")) {
                s.remove(number);
            } else if(str.equals("check")) {
                if(s.contains(number)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(str.equals("toggle")) {
                if(s.contains(number)) {
                    s.remove(number);
                } else {
                    s.add(number);
                }
            } else if(str.equals("all")) {
                for(int j = 1; j <= 20; j++) {
                    s.add(j);
                }
            } else if(str.equals("empty")) {
                for(int j = 1; j <= 20; j++) {
                    s.remove(j);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}