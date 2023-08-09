import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static boolean [] isPrime;
    static List<Integer> list = new ArrayList<>();
    static int [] dp;
    private final static int MOD = 123_456_789;

    public static void main(String[] args) throws IOException {
        input();
        primeNumber();
        System.out.println(solve());;
    }

    private static int solve() {
        dp = new int [N+1];

        dp[0] = 1;

        for (int i = 0; i < list.size(); i++) {
            int prime = list.get(i);
            for (int j = prime; j <= N; j++) {
                dp[j] = (dp[j] + dp[j - prime]) % MOD;
            }
        }

        return dp[N];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    private static void primeNumber() {
        isPrime = new boolean[40001];

        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= N; i++) {
            for (int j = i*i; j <= N; j+=i) {
                isPrime[j] = false;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]){
                list.add(i);
            }
        }
    }

}
