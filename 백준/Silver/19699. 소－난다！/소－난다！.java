import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int[] cows;
    static int N;
    static int M;
    static boolean[] isPrime = new boolean[9001];
    static boolean[] isVisited;
    static Set<Integer> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        solve(0, 0, 0);
        printResult();
    }

    private static void init() throws IOException {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(isPrime.length - 1); i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cows = new int[N];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve(int depth, int sum, int start) {
        if (depth == M) {
            if (isPrime[sum]) {
                result.add(sum);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                solve(depth + 1, sum + cows[i], i + 1);
                isVisited[i] = false;
            }
        }
    }
    
    private static void printResult() {
        if (result.size() == 0) {
            System.out.println(-1);
            return;
        }

        List<Integer> list = new ArrayList<>(result);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer l : list) {
            sb.append(l).append(" ");
        }

        System.out.println(sb);
    }
}