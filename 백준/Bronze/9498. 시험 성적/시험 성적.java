import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        
        char grade;
        if(number >= 90) {
            grade = 'A';
        } else if(number >= 80) {
            grade = 'B';
        } else if(number >= 70) {
            grade = 'C';
        } else if(number >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.print(grade);
    }
}