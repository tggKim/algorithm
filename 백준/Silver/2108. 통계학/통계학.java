import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			
			arr[number + 4000]++;
			list.add(number);
		}
		
		Collections.sort(list);
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		System.out.println(Math.round((double)sum / list.size()));
		System.out.println(list.get(list.size() / 2));
		
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(max <= arr[i]) {
				max = arr[i];
			}
		}
		int count = 0;
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(max == arr[i]) {
				count++;
				index = i;
				if(count == 2) {
					break;
				}
			}
		}
		System.out.println(index - 4000);
		
		System.out.println(list.get(list.size() - 1) - list.get(0));
	}
}