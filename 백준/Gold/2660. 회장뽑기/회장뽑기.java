import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 987654321;
    static int N;
    static int[][] arr ;

    public static void main(String[] args) throws NumberFormatException, IOException {
        init();

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int readerScore = INF;

        int[] scoreArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int score = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF) {
                    score = Math.max(score, arr[i][j]);
                }
            }

            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(readerScore + " ");

        int readerNum = 0;

        StringBuilder body = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (readerScore == scoreArr[i]) {
                readerNum++;
                body.append(i + " ");
            }
        }

        sb.append(readerNum);

        System.out.println(sb);
        System.out.println(body);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) {
                break;
            }

            arr[x][y] = arr[y][x] = 1;
        }
    }

}