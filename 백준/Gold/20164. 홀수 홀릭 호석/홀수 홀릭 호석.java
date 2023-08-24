import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int temp;

    public static void main(String[] args) throws IOException {
        input();
        divide(N);
        System.out.println(min + " " + max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
    }

    private static void divide(String input) {

        if (input.length() > 3){
            for (int i = 1; i < input.length() - 1; i++) {
                for (int j = i + 1; j < input.length(); j++) {
                    String a = input.substring(0, i);
                    String b = input.substring(i, j);
                    String c = input.substring(j);

                    temp += oddNumberFind(a);
                    temp += oddNumberFind(b);
                    temp += oddNumberFind(c);

                    divide(String.valueOf(Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c)));

                    temp -= oddNumberFind(a);
                    temp -= oddNumberFind(b);
                    temp -= oddNumberFind(c);
                }
            }

        }else if (input.length() == 2){

            temp += input.charAt(0) % 2;
            temp += input.charAt(1) % 2;

            divide(String.valueOf((input.charAt(0) - '0') + (input.charAt(1) - '0')));

            temp -= input.charAt(0) % 2;
            temp -= input.charAt(1) % 2;

        }else{

            temp += Integer.parseInt(input) % 2;

            max = Math.max(temp, max);
            min = Math.min(temp, min);

            temp -= Integer.parseInt(input) % 2;

            return;
        }

    }

    private static int oddNumberFind(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num % 2 == 1) {
                count++;
            }
        }

        return count;
    }

}
