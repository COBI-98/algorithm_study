import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int[][] map;
    public static int[][] test;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        test = new int[N][N];

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = st.charAt(j) - '0';
            }
        }

        divide(0, 0, N);

        System.out.println(sb);

    }

    public static void divide(int x, int y, int size) {

        if (movie(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }

        int next_size = size / 2;

        sb.append('(');
        divide(x, y, next_size);
        divide(x, y + next_size, next_size);
        divide(x + next_size, y, next_size);
        divide(x + next_size, y + next_size, next_size);

        sb.append(')');
    }

    public static boolean movie(int nx, int ny, int nsize) {

        int A = map[nx][ny];

        for (int i = nx; i < nx + nsize; i++) {
            for (int j = ny; j < ny + nsize; j++) {
                if (map[i][j] != A) {
                    return false;
                }
            }
        }

        return true;
    }

}
