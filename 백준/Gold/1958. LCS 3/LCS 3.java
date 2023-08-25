import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int STRINGS_THREE = 3;
    static String[] strList;
    static int dp[][][];
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());;

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strList = new String[STRINGS_THREE];
        for (int i = 0; i < STRINGS_THREE; i++) {
            strList[i] = br.readLine();
        }

        Arrays.sort(strList, Comparator.reverseOrder());
    }

    private static int solve() {
        int oneLen = strList[0].length();
        int twoLen = strList[1].length();
        int threeLen = strList[2].length();

        dp = new int[oneLen + 1][twoLen + 1][threeLen + 1];

        for(int i = 1; i <= oneLen; i++) {
            for(int j = 1; j <= twoLen; j++) {
                for(int k = 1; k <= threeLen; k++) {
                    if(strList[0].charAt(i-1) == strList[1].charAt(j-1) && strList[1].charAt(j-1) == strList[2].charAt(k-1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }

        return dp[oneLen][twoLen][threeLen];
    }
}
