import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sort(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void sort(int[] arr, int start, int end) {
		if(start < end) {
			int pivot = partition(arr, start, end);
			
			sort(arr, start, pivot - 1);
			sort(arr, pivot + 1, end);
		}
	}
	
	static int partition(int[] arr, int start, int end) {
		Random random = new Random();
		int num = start + random.nextInt(end - start + 1);
		int temp = arr[end];
		arr[end] = arr[num];
		arr[num] = temp;
		
		int index = start;
		for(int i = start; i < end; i++) {
			if(arr[i] < arr[end]) {
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				
				index++;
			}
		}
		
		temp = arr[index];
		arr[index] = arr[end];
		arr[end] = temp;
		
		return index;
	}
}