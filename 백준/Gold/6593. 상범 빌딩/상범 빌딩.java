import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    
    static int[] dl = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int L, R, C;
    static int l, r, c;
    static String[][][] build;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) break;
            build = new String[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] str = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        if (str[k].equals("S")) {
                            l = i;
                            r = j;
                            c = k;
                        }
                        build[i][j][k] = str[k];
                    }
                }
                br.readLine();
            }
            System.out.println(bfs());
        }
    }
    
    private static String bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];
        q.offer(new Pos(l, r, c, 0));
        visited[l][r][c] = true;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            if (build[p.l][p.r][p.c].equals("E")) {
                return "Escaped in " + p.s + " minute(s).";
            }
            for (int d = 0; d < 6; d++) {
                int nl = p.l + dl[d];
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (isCheck(nl, nr, nc, visited)) continue;
                q.offer(new Pos(nl, nr, nc, p.s+1));
                visited[nl][nr][nc] = true;
            }
        }
        return "Trapped!";
    }
    
    private static boolean isCheck(int nl, int nr, int nc, boolean[][][] visited) {
        return nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C || build[nl][nr][nc].equals("#") || visited[nl][nr][nc];
    }
    
    static class Pos {
        int l;
        int r;
        int c;
        int s;
        public Pos(int l, int r, int c, int s){
            this.l = l;
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}