import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] arr;
    static int[][] copyArr;
    static int[][] op;
    static int[] order;
    static boolean[] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        copyArr = new int[N + 1][M + 1];
        op = new int[K][3];
        order = new int[K];
        visited = new boolean[K];

        for (int r = 1; r < arr.length; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < arr[r].length; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < op.length; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < op[r].length; c++) {
                op[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        operate(0);

        System.out.println(min);

    }

    static void operate(int idx) { 
        if (idx == K) {
            copy();

            for (int i = 0; i < K; i++) {
                snail(order[i]);
            }

            min = Math.min(min, sum());
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            order[idx] = i;
            operate(idx + 1);
            visited[i] = false;
        }
    }

    private static void copy() {
        for (int r = 1; r < N + 1; r++) {
            for (int c = 1; c < M + 1; c++) {
                copyArr[r][c] = arr[r][c];
            }
        }
    }

    static void snail(int idx) {

        int r = op[idx][0];
        int c = op[idx][1];
        int s = op[idx][2];

        for (int i = 0; i < s; i++) {
            int startR = r - s + i;
            int startC = c - s + i;

            int borderR = r + s - i;
            int borderC = c + s - i;

            int currR = r - s + i;
            int currC = c - s + i;
            int tmp = copyArr[currR][currC];
            int d = 0;

            while (true) {

                int currV = tmp;

                int nr = currR + dx[d];
                int nc = currC + dy[d];

                if (nr > borderR || nr < startR || nc > borderC || nc < startC) {
                    d++;
                }
                tmp = copyArr[currR + dx[d]][currC + dy[d]];
                copyArr[currR + dx[d]][currC + dy[d]] = currV;

                if (nr == startR && nc == startC) {
                    break; 
                }

                currR += dx[d];
                currC += dy[d];

            }

        }

    }

    static int sum() {
        int minSum = Integer.MAX_VALUE;
        for (int r = 1; r < N + 1; r++) {
            int sum = 0;
            
            for (int c = 1; c < M + 1; c++) {
                sum += copyArr[r][c]; 
            }

            minSum = Math.min(sum, minSum);
        }

        return minSum;

    }

}