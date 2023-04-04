import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int target;
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (M == 0) {
            int result = Math.abs(target - 100);
            result = Math.min(result, (String.valueOf(target).length()));
            System.out.println(result);
        } else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            check = new boolean[10];
            for (int i = 0; i < M; i++) {
                check[Integer.parseInt(st.nextToken())] = true;
            }
            System.out.println(solution());
        }
    }

    private static int solution() {
        int result = Math.abs(target - 100);
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            if (isBroken(s)) {
                result = Math.min(result, s.length() + Math.abs(target - i));
            }
        }
        return result;
    }

    private static boolean isBroken(String s) {
        for (int j = 0; j < s.length(); j++) {
            if (check[s.charAt(j) - '0']) {
                return false;
            }
        }
        return true;
    }
}
