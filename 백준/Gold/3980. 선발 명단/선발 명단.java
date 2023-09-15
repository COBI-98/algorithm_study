import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {
    
    static int C;
    static int ans;
    static final int MAX_PLAYER = 11;
    static int[][] ability;
    static boolean[] positionFiled;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        C = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < C; test_case++) {
            ans = -1;
            ability = new int[MAX_PLAYER][MAX_PLAYER];
            positionFiled = new boolean[MAX_PLAYER];

            for (int i = 0; i < MAX_PLAYER; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < MAX_PLAYER; j++) {
                    ability[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve(0, 0);
            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }


    static void solve(int idx, int sum) {
        if (idx == 11) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 11; ++i) {
            if (positionFiled[i] || ability[idx][i] == 0) continue;
            positionFiled[i] = true;
            solve(idx+1, sum + ability[idx][i]);
            positionFiled[i] = false;
        }
    }
}
