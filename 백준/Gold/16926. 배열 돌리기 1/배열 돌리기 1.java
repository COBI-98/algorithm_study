import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(n, m);

        for (int i = 0; i < r; i++) {
            arr = rotate(arr, min, n, m);
        }

        printArr(arr, n, m);
    }

    static int[][] rotate(int[][] arr, int min, int n, int m) {

        for (int t = 0; t < min / 2; t++) {
            int x = t;
            int y = t;

            int temp = arr[x][y];

            int idx = 0;
            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (nx < n - t && ny < m - t && nx >= t && ny >= t) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
                else {
                    idx++;
                }

            }

            arr[t + 1][t] = temp; 
        }
        return arr;
    }

    static void printArr(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}