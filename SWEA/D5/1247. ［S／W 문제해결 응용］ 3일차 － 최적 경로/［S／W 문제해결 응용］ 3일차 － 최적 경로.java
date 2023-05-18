import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

class Solution{
    static int homeX;
    static int homeY;
    static int[][] customer;
    static int min;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int officeX = Integer.parseInt(st.nextToken());
            int officeY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            customer = new int[N][2];

            for (int i = 0; i < N; i++) {
                customer[i][0] = Integer.parseInt(st.nextToken());
                customer[i][1] = Integer.parseInt(st.nextToken());
            }
            visit(0, officeX, officeY, 0);

            sb.append("#" + tc + " " + min + "\n");
        }

        System.out.println(sb);
    }

    static void visit(int depth, int x, int y, int curDis) {
        if (min <= curDis) {
            return;
        }
        if (depth == N) {
            min = Math.min(curDis + getDis(x, y, homeX, homeY), min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                visit(depth + 1, customer[i][0], customer[i][1], curDis + getDis(x, y, customer[i][0], customer[i][1]));
                visited[i] = false;
            }
        }
    }

    static int getDis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}