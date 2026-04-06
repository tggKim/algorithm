import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            
            // 입력의 종료 조건: 점 하나(".")가 들어오면 무한루프 종료
            if (line.equals(".")) {
                break;
            }

            // 판별 함수를 호출해서 결과에 따라 yes 또는 no를 StringBuilder에 쌓음
            if (isBalanced(line)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        
        // 마지막에 한 번에 출력
        System.out.print(sb);
    }

    // 균형잡힌 문자열인지 확인하는 메서드
    static boolean isBalanced(String s) {
        // 우리가 배운 가장 완벽한 스택 선언법!
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 1. 여는 괄호면 무조건 스택에 넣는다 (push)
            if (c == '(' || c == '[') {
                stack.push(c);
            } 
            // 2. 소괄호 닫기 ')' 인 경우
            else if (c == ')') {
                // 스택이 비어있거나, 맨 위가 짝꿍 '(' 가 아니면 불균형!
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                // 짝이 맞으면 스택에서 뺀다 (pop)
                stack.pop();
            } 
            // 3. 대괄호 닫기 ']' 인 경우
            else if (c == ']') {
                // 스택이 비어있거나, 맨 위가 짝꿍 '[' 가 아니면 불균형!
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                // 짝이 맞으면 스택에서 뺀다 (pop)
                stack.pop();
            }
            // 영단어나 공백 등 다른 문자는 그냥 무시하고 넘어감
        }

        // 4. 문장을 끝까지 다 돌았는데 스택에 괄호가 남아있으면 불균형(false), 다 비워졌으면 완벽한 균형(true)!
        return stack.isEmpty();
    }
}