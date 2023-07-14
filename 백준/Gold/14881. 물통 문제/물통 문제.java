import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static long a;
    static long b;
    static long c;
    private final static String FALSE = "NO";
    private final static String TRUE = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if (a < c && b < c) {
                System.out.println(FALSE);
                continue;
            }

            if (a == c || b == c) {
                System.out.println(TRUE);
                continue;
            }

            long gcdValue;
            if (a < b) {
                gcdValue = calculateGCD(a, b);

                if (gcdValue == 1) {
                    if (b >= c) {
                        System.out.println(TRUE);
                    } else {
                        System.out.println(FALSE);
                    }
                    continue;
                }

            } else {
                gcdValue = calculateGCD(b, a);

                if (gcdValue == 1) {
                    if (a >= c) {
                        System.out.println(TRUE);
                    } else {
                        System.out.println(FALSE);
                    }
                    continue;
                }

            }

            if (c % gcdValue == 0) {
                System.out.println(TRUE);
            } else {
                System.out.println(FALSE);
            }
        }
    }

    private static long calculateGCD(long a, long b) {
        while (b != 0) {
            long target = b;
            b = a % b;
            a = target;
        }
        return a;
    }
}
