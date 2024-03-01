import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> nn = new ArrayList<>();
    static List<Integer> pn = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                pn.add(n);
            } else {
                nn.add(n);
            }
        }
    }

    private static void solve() {
        Collections.sort(pn, Collections.reverseOrder());
        Collections.sort(nn);

        int i = 0;
        while (i < pn.size()) {
            if (i + 1 < pn.size() && pn.get(i) != 1 && pn.get(i + 1) != 1) {
                sum += pn.get(i++) * pn.get(i++);
            } else {
                sum += pn.get(i++);
            }
        }

        i = 0;
        while (i < nn.size()) {
            if (i + 1 < nn.size() && nn.get(i) != 1 && nn.get(i + 1) != 1) {
                sum += nn.get(i++) * nn.get(i++);
            } else {
                sum += nn.get(i++);
            }
        }
    }

    private static void printResult() {
        System.out.println(sum);
    }
}