import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int numOfDice;
    static int[][] diceInfo;
    static int[] faceTofaceInfo = {5, 3, 4, 1, 2, 0};
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        numOfDice = Integer.parseInt(br.readLine());

        diceInfo = new int[numOfDice][6];
        for (int i = 0; i < numOfDice; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                diceInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {

        result = 0;

        for (int i = 0; i < 6; i++) {
            int maxNextValue = 0;
            for (int j = 0; j < 6; j++) {
                if (j == i) {
                    continue;
                }
                if (j == faceTofaceInfo[i]) {
                    continue;
                }
                maxNextValue = Math.max(maxNextValue, diceInfo[0][j]);
            }
            setDiceState(diceInfo[0][i], maxNextValue);
        }
    }

    static void setDiceState(int topOfFirstDice, int maxNextValueOfFirstDice) {

        int maxSumOfNextValue = maxNextValueOfFirstDice;

        int topOfDice = topOfFirstDice;

        for (int i = 1; i < numOfDice; i++) {

            int topIdx = 0;
            for (int j = 0; j < diceInfo[i].length; j++) {
                if (topOfDice == diceInfo[i][j]) {
                    topOfDice = diceInfo[i][faceTofaceInfo[j]];
                    topIdx = j;
                    break;
                }
            }

            int maxNextValue = 0;

            for (int j = 0; j < 6; j++) {
                if (j == topIdx) {
                    continue;
                }
                if (j == faceTofaceInfo[topIdx]) {
                    continue;
                }
                maxNextValue = Math.max(maxNextValue, diceInfo[i][j]);
            }

            maxSumOfNextValue += maxNextValue;
        }

        result = Math.max(result, maxSumOfNextValue);
    }

    static void printResult() {
        System.out.println(result);
    }
}