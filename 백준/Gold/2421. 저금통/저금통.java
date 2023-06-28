import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    static int N;
    static int[][] dp;
    static int[] sosu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp = new int[1000][1000];
        sosu = new int[1000010];

        Arrays.fill(sosu, 0);

        //에라토스테네스의 체
        for (int i = 2; i * i <= 1000000; i++) {
            for (int j = i + i; j <= 1000000; j += i) {
                sosu[j] = 1;
            }
        }

        for (int i = 0; i < 1000; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[1][1] = 0;
        System.out.println(putMoneyInBank(N, N));
    }

    static int putMoneyInBank(int x, int y) {
        if (x < 1 || y < 1){
            return 0;
        }

        if (dp[x][y] != -1){
            return dp[x][y];
        }

        int ret = 0;
        ret = Math.max(ret, Math.max(putMoneyInBank(x - 1, y), putMoneyInBank(x, y - 1)));
        ret += getSosu(x, y);
        
        return dp[x][y] = ret;
    }

    static int getSosu(int x, int y) {
        int ty = y;
        int cnt = 0;

        while (ty > 0) {
            ty /= 10;
            x *= 10;
        }

        x += y;
        if (sosu[x] == 1){ // 소수가아니라면
            return 0;
        }
        
        return 1;
    }
}







