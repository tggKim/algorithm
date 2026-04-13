import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
    	Set<String> set0 = new HashSet<>();
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			set0.add(str);
			set1.add(str);
		}
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			set0.add(str);
			set2.add(str);
		}

        List<String> list = new ArrayList<>(set0);
        List<String> answerList = new ArrayList<>();
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			
			if(set1.contains(str) && set2.contains(str)) {
    			answerList.add(str);
			}
		}
		
		bw.write(answerList.size() + "\n");
        for(int i = 0; i < answerList.size(); i++) {
            bw.write(answerList.get(i) + "\n");
        }

        bw.flush();
        bw.close();
	}
}
