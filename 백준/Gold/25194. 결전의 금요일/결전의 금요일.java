import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final String POSSIBLE = "YES";
    static final String IMPOSSIBLE = "NO";
    static int N;
    static int cnt = 0;
    static boolean result = false;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a % 7 != 0) {
                cnt++;
                list.add(a);
            }
        }
    }

    private static void solve() {
        if(cnt >= 7)
            result = true;
        else {
            dfs(0,0, list.size());
        }
    }

    static void dfs(int idx, int tmp, int depth) {
        if(idx == depth){
            return;
        }
        if((tmp + list.get(idx)) % 7 == 4)
            result = true;
        dfs(idx+1, tmp, depth);
        dfs(idx+1, tmp+list.get(idx), depth);
    }

    private static void printResult() {
        if(result)
            System.out.println(POSSIBLE);
        else
            System.out.println(IMPOSSIBLE);
    }
}