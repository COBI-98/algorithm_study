import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int l;
    static int n;
    static String[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new String[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);
        solve(new String[l], 0, l);
        System.out.println("NONE");
    }

    static void solve(String[] result, int d, int r) {
        if (d == r) {
            if (validateStr(result)) {
                StringBuilder b = new StringBuilder();
                for (String s : result) {
                    b.append(s).append('\n');
                }
                System.out.println(b);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[d] = arr[i];
                solve(result, d + 1, r);
                visited[i] = false;
            }
        }
    }

    static boolean validateStr(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int k = 0; k < str.length; k++) {
                if (str[i].charAt(k) != str[k].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}