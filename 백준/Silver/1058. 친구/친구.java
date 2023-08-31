import java.io.*;

public class Main {
    static int N;
    static char[][] friend;
    static boolean[][] isFriend;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        solve();
        printResult();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        friend = new char[N][N];
        isFriend = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                friend[i][j] = str.charAt(j);
            }
        }
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int twoFriend = 0;
            for (int j = 0; j < N; j++) {
                if (friend[i][j] == 'Y') {
                    isFriend[i][j] = true;
                    for (int k = 0; k < N; k++) {
                        if (friend[j][k] == 'Y') {
                            isFriend[i][k] = true;
                        }
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (isFriend[i][j]) {
                    twoFriend++;
                }
            }

            max = Math.max(max, twoFriend);
        }
    }

    private static void printResult() {
        System.out.println(max);
    }

}
