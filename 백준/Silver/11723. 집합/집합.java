import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        int bitset = 0; // 비트마스킹을 위한 정수 (0이 공집합)
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            
            if (op.equals("all")) {
                bitset = (1 << 21) - 1; // 1~20까지 모든 비트를 1로 켬
            } else if (op.equals("empty")) {
                bitset = 0; // 모든 비트를 0으로 끔
            } else {
                int num = Integer.parseInt(st.nextToken());
                
                if (op.equals("add")) {
                    bitset |= (1 << num); // num번째 비트를 1로 (OR)
                } else if (op.equals("remove")) {
                    bitset &= ~(1 << num); // num번째 비트를 0으로 (AND NOT)
                } else if (op.equals("check")) {
                    sb.append((bitset & (1 << num)) != 0 ? 1 : 0).append("\n");
                } else if (op.equals("toggle")) {
                    bitset ^= (1 << num); // num번째 비트 상태 반전 (XOR)
                }
            }
        }
        System.out.print(sb.toString()); // 한 번에 출력
    }
}