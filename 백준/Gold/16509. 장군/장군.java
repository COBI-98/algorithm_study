import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int[] cx = {-1, 1, 1, -1};
    static int[] cy = {1, 1, -1, -1};

    static int kr,kc;

    static Queue<Node> q = new ArrayDeque<>();
    static boolean[][] visited = new boolean[10][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        visited[sr][sc] = true;
        q.add(new Node(sr, sc, 0));

        st = new StringTokenizer(br.readLine());
        kr = Integer.parseInt(st.nextToken());
        kc = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == kr && now.y == kc) {
                return now.step;
            }

            check(now);
        }
        return -1;
    }

    private static void check(Node n) {
        for(int d = 0 ; d < 4 ; d++) {
            int tx = n.x + dx[d];
            int ty = n.y + dy[d];

            if(isPossible(tx, ty)) {
                for(int cnt = 0; cnt < 2 ; cnt++) {
                    int s = (d + cnt) % 4;
                    int nx = tx + cx[s];
                    int ny = ty + cy[s];

                    if(isPossible(nx, ny)) {
                        nx += cx[s];
                        ny += cy[s];

                        if(inRange(nx, ny) && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new Node(nx, ny, n.step + 1));
                        }

                    }
                }
            }
        }
    }

    private static boolean isPossible(int x, int y) {
        if(x == kr && y == kc)
            return false;
        return inRange(x, y);
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < 10 && 0 <= y && y < 9;
    }
    static class Node {
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

}
