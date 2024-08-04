import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int price[];
    static int sale[][];
    static int minCost = Integer.MAX_VALUE;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        init();
        solve(0, 0);
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        price = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        sale = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int saleIdx = Integer.parseInt(st.nextToken());
                int salePrice = Integer.parseInt(st.nextToken());
                sale[i][saleIdx] = salePrice;
            }
        }

        visited = new boolean[N + 1];
    }


    private static void solve(int depth, int cost) {
        if (cost >= minCost) {
            return;
        }
        if (depth == N) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            
            int originPrice[] = Arrays.copyOf(price, N + 1);
            for (int j = 1; j < N + 1; j++) {
                if (price[j] - sale[i][j] <= 0) {
                    price[j] = 1;
                } else {
                    price[j] -= sale[i][j];
                }
            }
            solve(depth + 1, cost + price[i]);
            price = Arrays.copyOf(originPrice, N + 1);
            visited[i] = false;
        }
    }

    private static void printResult() {
        System.out.println(minCost);
    }
}