import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static final String PRINT_FORMAT = "#%d %s";
    private static final String ON = "ON";
    private static final String OFF = "OFF";
    private static int N;
    private static int M;
    private static int TC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= TC; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(String.format(PRINT_FORMAT
                            , test_case
                            , (((1 << N) - 1 & M) == (1 << N) - 1) ? ON: OFF))
                            .append("\n");
        }

        System.out.println(sb);
    }
}
