import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] paper = new int[3];
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(paper[0]);
        System.out.println(paper[1]);
        System.out.println(paper[2]);
    }

    public static void divide(int x, int y, int nextSize) {
        if (paperCheck(x, y, nextSize)) {
            if (map[x][y] == -1) {
                paper[0]++;
            } else if (map[x][y] == 0) {
                paper[1]++;
            } else {
                paper[2]++;
            }

            return;
        }

        int nsize = nextSize / 3;

        divide(x, y, nsize);
        divide(x + nsize, y, nsize);
        divide(x + (nsize * 2), y, nsize);

        divide(x, y + nsize, nsize);
        divide(x, y + (nsize * 2), nsize);
        divide(x + nsize, y + nsize, nsize);

        divide(x + nsize, y + (nsize * 2), nsize);
        divide(x + (nsize * 2), y + nsize, nsize);
        divide(x + (nsize * 2), y + (nsize * 2), nsize);
    }

    public static boolean paperCheck(int x, int y, int size) {
        int A = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != A) {
                    return false;
                }
            }
        }

        return true;
    }
}
