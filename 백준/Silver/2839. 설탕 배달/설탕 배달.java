import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0; // 봉지 개수
        
        // 설탕이 남아있는 동안 계속 반복
        while (N >= 0) {
            // 1. 남은 설탕이 5로 딱 나누어 떨어지면 개이득!
            if (N % 5 == 0) {
                count += (N / 5);   // 5kg 봉지 개수만큼 더해주고
                System.out.println(count);
                return;             // 정답을 찾았으니 프로그램 바로 종료
            }
            
            // 2. 5로 안 나누어 떨어지면, 3kg 봉지 하나를 쓴다.
            N -= 3;
            count++;
        }
        
        // 3. 3kg씩 계속 뺐는데 결국 N이 음수(-1, -2)가 되어버렸다면?
        // 이건 3과 5로 딱 맞출 수 없는 무게라는 뜻 (예: 4kg)
        System.out.println(-1);
    }
}