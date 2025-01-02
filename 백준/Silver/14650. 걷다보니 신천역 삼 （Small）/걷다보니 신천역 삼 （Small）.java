import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    
    static int N;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
    
    private static void solve() {
        if (N != 1){
            cnt = 2 * (int) Math.pow(3, N - 2);
        }
    }
    
    private static void printResult() {
        System.out.println(cnt);
    }
}