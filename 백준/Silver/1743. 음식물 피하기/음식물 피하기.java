import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K,ans,cnt;
    static int dx[]= {-1,1,0,0};
    static int dy[]= {0,0,-1,1};
    static boolean[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1]=true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j]) {
                    cnt=0;
                    dfs(i,j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);

    }

    private static void dfs(int x, int y) {
        cnt++;
        visited[x][y]=true;
        for (int k = 0; k < 4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];

            if(nx<0 || ny<0 || nx>=N || ny>=M)continue;
            if(!visited[nx][ny]&& map[nx][ny]) {
                dfs(nx,ny);
            }
        }
    }
}