import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int totalPopulation = 0;
    static int populationMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                totalPopulation += map[i][j];
            }
        }
    }

    private static int solve() {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) {
                            continue;
                        }
                        if (y - d1 < 0 || y + d2 >= N) {
                            continue;
                        }

                        populationMin = Math.min(populationMin, bruteforce(x, y, d1, d2));
                    }
                }
            }
        }

        return populationMin;
    }

    private static int bruteforce(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N+1][N+1];

        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] peopleSum = new int[5];

        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (border[i][j]) {
                    break;
                }
                peopleSum[0] += map[i][j];
            }
        }

        for (int i = 1; i <= x + d2; i++) {
            for (int j = N ; j > y; j--) {
                if (border[i][j]) {
                    break;
                }
                peopleSum[1] += map[i][j];
            }
        }

        for (int i = x + d1; i <= N; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (border[i][j]) {
                    break;
                }
                peopleSum[2] += map[i][j];
            }
        }

        for (int i = x + d2 + 1; i <= N; i++) {
            for (int j = N ; j >= y - d1 + d2; j--) {
                if (border[i][j]) {
                    break;
                }
                peopleSum[3] += map[i][j];
            }
        }

        peopleSum[4] = totalPopulation;

        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        Arrays.sort(peopleSum);

        return peopleSum[4] - peopleSum[0];
    }
    
}