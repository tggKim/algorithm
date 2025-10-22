import java.util.*;
import java.io.*;

public class Main {
    static int[] number = new int[100001];
    static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(N);
        number[N] = 1;

        if(N == K) {
            System.out.print(0);
            return;
        }
		
		while(!q.isEmpty()) {
			int x = q.removeFirst();

            for(int i=0;i<3;i++) {
                int numX;
                
                if(i==0){
                    numX=x+1;
                }
                else if(i==1){
                    numX=x-1;
                }
                else{
                    numX=x*2;
                }

                if(numX==K){
                    System.out.println(number[x]);
                    return;
                }

                if(numX>=0&&numX<number.length&&number[numX]==0) {
                    q.add(numX);
                    number[numX]=number[x]+1;
                }
                
            }
            
		}
	}
}