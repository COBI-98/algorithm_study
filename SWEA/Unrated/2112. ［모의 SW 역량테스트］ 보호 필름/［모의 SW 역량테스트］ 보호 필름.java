import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Solution {
    static int T;
    static int D;
    static int W;
    static int K;
    static int[][] films;
    static int[][] copyFilms;
    static int result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            films = new int[D][W];
            copyFilms = new int[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    films[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < D; i++) {
                copyFilms[i] = films[i].clone();
            }

            result = K;
            if (filmsSafetyCheck()) {
                result = 0;
            } else {
                DFS(0, 0);
            }

            sb.append("#" + test_case + " " + result + "\n");
        }

        System.out.println(sb);
    }

    static void DFS(int idx, int count) {
        if (count >= result) {
            return;
        }

        if (idx == D) {
            if (filmsSafetyCheck()) {
                result = Math.min(result, count);
            }
            return;
        }

        DFS(idx + 1, count);

        for (int i = 0; i < W; i++) {
            copyFilms[idx][i] = 0;
        }

        DFS(idx + 1, count + 1);

        for (int i = 0; i < W; i++) {
            copyFilms[idx][i] = 1;
        }

        DFS(idx + 1, count + 1);

        for (int i = 0; i < W; i++) {
            copyFilms[idx][i] = films[idx][i];
        }
    }


    private static boolean filmsSafetyCheck() {
        int KCheck = 0;
        for (int i = 0; i < W; i++) {
            int cellCount = 1;

            for (int j = 1; j < D; j++) {
                int cell = copyFilms[j - 1][i];
                int cur_cell = copyFilms[j][i];
                if (cell == cur_cell) {
                    cellCount++;
                } else {
                    cellCount = 1;
                }

                if (cellCount >= K) {
                    KCheck++;
                    break;
                }
            }
        }

        if (KCheck < W){
            return false;
        }

        return true;
    }
}
