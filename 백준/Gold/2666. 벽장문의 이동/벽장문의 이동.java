import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int door1;
    static int door2;
    static int[] doors;
    static int[][][] dp;
    static int useTime;

    static int result = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        door1 = Integer.parseInt(st.nextToken());
        door2 = Integer.parseInt(st.nextToken());

        useTime = Integer.parseInt(br.readLine());
        doors = new int[useTime];
        dp = new int[useTime][N + 1][N + 1];

        for (int i = 0; i < useTime; i++) {
            for (int j = 0; j < N + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < useTime; i++) {
            doors[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(move(0, door1, door2));

    }

    static int move(int useIndex, int door1, int door2) {

        if (useIndex == useTime) {
            return 0;
        }

        if (dp[useIndex][door1][door2] != -1) {
            return dp[useIndex][door1][door2];
        }

        return dp[useIndex][door1][door2] = dp[useIndex][door2][door1] = Math.min(Math.abs(door1 - doors[useIndex]) + move(useIndex + 1, doors[useIndex], door2), Math.abs(door2 - doors[useIndex]) + move(useIndex + 1, door1, doors[useIndex]));
    }
}