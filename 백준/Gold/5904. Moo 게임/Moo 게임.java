import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new int[30];

        divide(N);
    }
    
    public static void divide(int x) {
        if (x <= 3) {
            if (x == 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
            return;
        }

        S[0] = 3;
        int index = 0;
        while (x > S[index]) {
            index++;
            S[index] = S[index - 1] * 2 + index + 3;
        }

        //중앙 2
        if (S[index - 1] < x && x <= (S[index - 1] + index + 3)) {
            if (x == S[index - 1] + 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
        } else { // 우측
            divide(x - (S[index - 1] + index + 3));
        }
    }
}
