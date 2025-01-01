import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, whites[], blacks[], dp[][][];
    private static void input() throws IOException {
        whites = new int[1001];
        blacks = new int[1001];
        dp = new int[1001][16][16];
        N = 0;
        String s = "";
        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            N++;
            whites[N] = Integer.parseInt(st.nextToken());
            blacks[N] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dfs(N, 15, 15));
    }
    private static int dfs(int pIndex, int white, int black) {
        
        if (pIndex == 0) return 0;
        
        if (white == 0 && black == 0) return 0;
       
        if (dp[pIndex][white][black] != 0) return dp[pIndex][white][black];
        
        int answer = dfs(pIndex - 1, white, black);
        
        if (white > 0) answer = Math.max(answer, dfs(pIndex - 1, white - 1, black) + whites[pIndex]);
        
        if (black > 0) answer = Math.max(answer, dfs(pIndex - 1, white, black - 1) + blacks[pIndex]);
        return dp[pIndex][white][black] = answer;
    }
}