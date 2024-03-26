import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean isPrime[] = new boolean[1_004_002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        calculateNumberTheory();

        for (int i = n; i < 1004000; i++) {
            if (!isPrime[i]) {
                String str = String.valueOf(i);
                StringBuffer sb = new StringBuffer(str);
                String reverseStr = sb.reverse().toString();

                if (str.equals(reverseStr)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    static void calculateNumberTheory() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }
}