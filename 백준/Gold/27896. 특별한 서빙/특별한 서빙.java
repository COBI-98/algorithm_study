import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int dissNum = Integer.parseInt(st.nextToken());
            pq.add(dissNum);
            sum += dissNum;

            while(sum >= M){
                sum -= (pq.poll() * 2);
                ans++;
            }
        }

        System.out.println(ans);
    }
    
}