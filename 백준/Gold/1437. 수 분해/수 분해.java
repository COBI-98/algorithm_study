import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD_CONDITION =  10_007;
    static int n;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    public static void solve() {
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
            result %= MOD_CONDITION;
        }
        result *= n;
        result %= MOD_CONDITION;
        System.out.println(result);
    }
}