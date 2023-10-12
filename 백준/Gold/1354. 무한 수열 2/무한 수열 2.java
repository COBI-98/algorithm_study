import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static HashMap<Long, Long> hashMap = new HashMap<>();
    private static long N;
    private static int P;
    private static int Q;
    private static int X;
    private static int Y;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve(N));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

    }

    public static long solve(long n){

        if(n <= 0) return 1;
        if(hashMap.containsKey(n)){
            return hashMap.get(n);
        }
        long a = solve((n / P) - X);
        long b = solve((n / Q) - Y);

        hashMap.put(n, a+b);
        return hashMap.get(n);
    }
    
}
