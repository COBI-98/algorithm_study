import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static final int MIN_SIZE = 1;
    static final int MAX_SIZE = 5;
    static int K;
    static int max = 0;
    static int[][] map;
    static int answer = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        map = new int[MAX_SIZE + 1][MAX_SIZE + 1];

        for (int i = 1; i <= MAX_SIZE; i++) {
            for (int j = 1; j <= MAX_SIZE; j++) {
                map[i][j] = 1; // 사과
            }
        }

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[A][B] = 0; // 돌
        }

        map[MIN_SIZE][MIN_SIZE] = 2;

        dfs(MIN_SIZE,MIN_SIZE,1);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int depth){

        if (x == MAX_SIZE && y == MAX_SIZE){
            if (depth == 25-K ){
                answer++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > MAX_SIZE || ny > MAX_SIZE || nx < MIN_SIZE || ny < MIN_SIZE || map[nx][ny] == 2){
                continue;
            }

            if (map[nx][ny] != 2 && map[nx][ny] != 0){
                map[nx][ny] = 2;
                dfs(nx,ny,depth+1);
                map[nx][ny] = 1;
            }
        }
    }
}
