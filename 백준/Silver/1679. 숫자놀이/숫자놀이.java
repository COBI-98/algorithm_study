import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final String PLAYER_HOL = "holsoon";
    static final String PLAYER_JJAK = "jjaksoon";
    static int N;
    static int maxUse;
    static int[] numList;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult(findWinner());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numList[n] = Integer.parseInt(st.nextToken());
        }

        maxUse = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        list.add(0);
        while (true) {
            int cur = list.size();
            int minUse = Integer.MAX_VALUE;
            for (int num : numList) {
                int index = cur - num;
                if (index >= 0 && list.get(index) < maxUse) {
                    minUse = Math.min(minUse, list.get(index) + 1);
                }
            }
            if (minUse == Integer.MAX_VALUE) {
                break;
            } else {
                list.add(minUse);
            }
        }
    }

    private static String findWinner() {
        if (list.size() % 2 == 1) {
            return PLAYER_JJAK;
        }

        return PLAYER_HOL;
    }

    private static void printResult(String winner) {
        System.out.println(winner + " win at " + (list.size()));
    }
}