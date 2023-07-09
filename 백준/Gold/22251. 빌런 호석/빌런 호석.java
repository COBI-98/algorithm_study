import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 몇층까지
    static int K; // 자릿수
    static int P; // 바꿀수있는
    static int X; // 현재 층
    static final int LIGHT = 7;
    static int[][] arr = {{1, 1, 0, 1, 1, 1, 1},  // 맨위 부터시계방향
            {0, 1, 0, 0, 1, 0, 0},
            {1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 0},
            {1, 0, 1, 1, 1, 1, 0},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int cur[] = modifyNumberToList(X);

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }

            if (isDisplayNumberWithCur(i, cur)) {
                sum++;
            }
        }

        System.out.println(sum);
    }
    

    public static int[] modifyNumberToList(int x) {
        int[] result = new int[K];
        for(int i = K - 1; i >= 0; i--) {
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }

    private static boolean isDisplayNumberWithCur(int target, int[] cur) {

        int[] targetList = modifyNumberToList(target);

        int count = 0;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < LIGHT; j++) {
                if (arr[cur[i]][j] != arr[targetList[i]][j]) {
                    count++;
                    if (count > P) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
