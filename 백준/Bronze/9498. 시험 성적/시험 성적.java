import java.util.Scanner;
public class Main {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        System.out.print(getGrade(score));
    }
    
    private static String getGrade(int score) {
        if( score >= 90 ) return "A";
        if( score >= 80 ) return "B";
        if( score >= 70 ) return "C";
        if( score >= 60 ) return "D";
        return "F";
    }
   
}