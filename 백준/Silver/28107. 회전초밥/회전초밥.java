import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    private static final int MAX_SIZE = 200_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        
        Queue<Integer>[] q = new Queue[MAX_SIZE + 1];
        for (int i = 0; i <= MAX_SIZE; i++) {
            q[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = stoi.apply(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int num = stoi.apply(st.nextToken());
                q[num].add(i);
            }
        }
        
        st = new StringTokenizer(br.readLine());
        
        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            int sushi = stoi.apply(st.nextToken());
            if (!q[sushi].isEmpty()) {
                cnt[q[sushi].poll()]++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(cnt[i] + " ");
        }
    }
}