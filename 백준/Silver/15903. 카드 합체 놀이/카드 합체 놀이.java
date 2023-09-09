import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while(m > 0){
            Long a1 = pq.poll();
            Long a2 = pq.poll();

            Long sum = a1 + a2;

            pq.add(sum);
            pq.add(sum);

            m--;
        }

        long ans = pq.stream()
                .mapToLong(Long::longValue)
                .sum();

        System.out.println(ans);
    }
}