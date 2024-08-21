import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int N;
    static int[][] farm;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            init();
            sb.append("#")
                    .append(test_case)
                    .append(" ")
                    .append(solve())
                    .append("\n");
        }

        printResult();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        farm = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int value = str.charAt(j) - '0';
                farm[i][j] = value;
            }
        }
    }

    private static int solve() {
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(Math.abs(i - N/2) + Math.abs(j - N/2) <= N/2)
                    result += farm[i][j];
            }
        }

        return result;
    }

    private static void printResult() {
        System.out.println(sb);
    }
}
