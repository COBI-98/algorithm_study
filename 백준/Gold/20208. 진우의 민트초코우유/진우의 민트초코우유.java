import java.util.*;
import java.io.*;

public class Main {

    static final int HOME = 1;
    static final int MINT = 2;
    static Point homeLoc;
    static int H, ans;
    static boolean[] visited;
    static List<Point> milks = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == HOME) {
                    homeLoc = new Point(r, c);
                } else if (input == MINT) {
                    milks.add(new Point(r, c));
                }
            }
        }

        visited = new boolean[milks.size()];
        dfs(homeLoc, 0, M);

        System.out.println(ans);
    }

    public static void dfs(Point start, int score, int hp) {
        if (canGo(start, homeLoc, hp)) {
            ans = Math.max(ans, score);
        }

        for (int i = 0; i < milks.size(); i++) {
            Point cur = milks.get(i);

            if (!visited[i] && canGo(start, cur, hp)) {
                visited[i] = true;
                dfs(cur, score + 1, hp + H - calcDist(start, cur));
                visited[i] = false;
            }
        }
    }

    public static boolean canGo(Point from, Point to, int hp) {
        return calcDist(from, to) <= hp;
    }

    public static int calcDist(Point from, Point to) {
        return Math.abs(from.c - to.c) + Math.abs(from.r - to.r);
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}