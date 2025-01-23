import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int t;
    static final int MAX = 1000000000;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        solve();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < list.size(); j++) {
                if (num < list.get(j)) {
                    sb.append(j).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static void solve() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int tmp = 0;
        while (list.get(tmp + 1) <= MAX) {
            list.add(list.get(tmp) + list.get(tmp + 1) + 1);
            tmp++;
        }
        list.add(list.get(tmp) + list.get(tmp + 1) + 1);
    }
}