import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Person[] arr = new Person[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] answer = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i != j) {
					if(arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
						answer[i]++;
					}
				}
			}
		}
		
		for(int i = 0;i < N; i++) {
			System.out.print(answer[i] + 1 + " ");
		}
	}
	
	static class Person {
		int weight;
		int height;
		
		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}
}