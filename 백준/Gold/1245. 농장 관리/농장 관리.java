import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int arr[][];
    static int answer;
    static int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean visit[][];
    static boolean top[][];
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        visit = new boolean[R][C];
        top = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != 0 && top[i][j] == false) {  
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);


    }

    static public void bfs(int r, int c) { 
        visit = new boolean[R][C];
        visit[r][c] = true;
        queue = new ArrayDeque<Point>();
        queue.add(new Point(r, c));
        ArrayList<Point> topList = new ArrayList<Point>();
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 8; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C && visit[nr][nc] == false) {

                    if (arr[nr][nc] > arr[cur.r][cur.c]) 
                    {
                        return;
                    } else if (arr[nr][nc] == arr[cur.r][cur.c]) { 
                        queue.add(new Point(nr, nc));
                        topList.add(new Point(nr, nc));
                    }

                    visit[nr][nc] = true;
                }
            }
        }
        for (int i = 0; i < topList.size(); i++) { 
            Point cur = topList.get(i);
            top[cur.r][cur.c] = true;
        }
        answer++; 
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