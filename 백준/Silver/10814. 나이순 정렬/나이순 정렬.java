import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
	
		Person[] arr = new Person[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Person person = new Person(age, name, i);
            arr[i] = person;
		}
		
		Arrays.sort(arr, (person1, person2) -> {
			if(person1.age != person2.age) {
				return person1.age - person2.age;
			} else {
				return person1.index - person2.index;
			}
		});
		
		for(int i = 0; i < arr.length; i++) {
			bw.write(arr[i].age + " " +arr[i].name + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static class Person {
		int age;
		String name;
		int index;
		
		Person(int age, String name, int index) {
			this.age = age;
			this.name = name;
			this.index = index;
		}
	}
}