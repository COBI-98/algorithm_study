import java.io.*;
import java.util.*;

public class Main {
    static int P, Q;
    static long N;
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map.put(0L, 1L);

        System.out.println(solve(N));
    }

    static long solve(long num) {

        if(num==0) return 1;
        if(map.containsKey(num)) return map.get(num);

        long a= (long)Math.floor(num/P);
        long b= (long)Math.floor(num/Q);

        map.put(num, solve(a)+solve(b));
        return map.get(num);
    }
    
}