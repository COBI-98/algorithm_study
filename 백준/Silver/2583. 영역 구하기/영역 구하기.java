import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int M;
    public static int N;
    public static int square;
    public static int[][] map;
    public static boolean[][] visit;
    public static int count;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static ArrayList<Integer> arr = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        square = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];


        for (int i = 0; i < square; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            for (int j = A; j < C; j++) {
                for (int k = B; k < D; k++) {
                    map[j][k] = -1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != -1 && !visit[i][j]){
                    count = 1;
                    dfs(i,j);
                    arr.add(count);
                }
            }
        }

        System.out.println(arr.size());
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void dfs(int x, int y){

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && ny>=0 && nx<M && ny<N){
                if (!visit[nx][ny] && map[nx][ny] != -1){
                    dfs(nx,ny);
                    count++;
                }
            }
        }

    }

}
