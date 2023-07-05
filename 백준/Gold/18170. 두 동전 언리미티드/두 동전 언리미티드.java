import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N;
    static int M;
    static char[][] arr;
    static boolean[][][][] vis;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        vis = new boolean[N][M][N][M];
        q = new LinkedList<>();

        int a = -1, b = 0, c = 0, d = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'o') {
                    if (a == -1) {
                        a = i;
                        b = j;
                    } else {
                        c = i;
                        d = j;
                    }
                }
            }
        }

        q.offer(new Node(a, b, c, d));
        vis[a][b][c][d] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int tmp = q.size();

            for (int w = 0; w < tmp; w++) {
                a = q.peek().a;
                b = q.peek().b;
                c = q.peek().c;
                d = q.peek().d;
                q.poll();

                vis[a][b][c][d] = true;

                for (int i = 0; i < 4; i++) {
                    int ta = a + dx[i];
                    int tb = b + dy[i];
                    int tc = c + dx[i];
                    int td = d + dy[i];

                    if ((chk(ta, tb) && !chk(tc, td)) || (!chk(ta, tb) && chk(tc, td))) {
                        System.out.println(cnt + 1);
                        return;
                    } else if (!chk(ta, tb) && !chk(tc, td)) {
                        if (arr[ta][tb] == '#') {
                            ta = a;
                            tb = b;
                        }
                        if (arr[tc][td] == '#') {
                            tc = c;
                            td = d;
                        }
                        if (!vis[ta][tb][tc][td]) {
                            q.offer(new Node(ta, tb, tc, td));
                        }
                    }
                }
            }
            cnt++;
        }

        System.out.println(-1);
    }

    public static boolean chk(int a, int b) {
        return a >= N || a < 0 || b >= M || b < 0;
    }
    
    static class Node {
        int a, b, c, d;

        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
}