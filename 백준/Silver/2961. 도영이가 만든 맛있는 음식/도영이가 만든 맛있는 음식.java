import java.io.*;
import java.util.*;

public class Main {
    
    static int N, answer = Integer.MAX_VALUE;
    static int[][] ingredient;
    static boolean[] selected;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }
        solve(0, 1, 0, 0);
        System.out.println(answer);
    }

    static void solve(int depth, int sour, int bitter, int selectedCount) {
        if (depth == N) {
            if (selectedCount != 0) {
                if (Math.abs(sour - bitter) < answer) { 
                    answer = Math.abs(sour - bitter);
                }
            }
            return;
        }

        solve(depth + 1, sour * ingredient[depth][0], bitter + ingredient[depth][1], selectedCount + 1); 
        solve(depth + 1, sour, bitter, selectedCount); 
    }
}