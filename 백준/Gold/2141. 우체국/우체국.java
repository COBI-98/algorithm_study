import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Town> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());

            pq.offer(new Town(x, a));
            sum += a;
        }

        long temp = 0;
        for (int i = 0; i < N; i++) {
            Town cur = pq.poll();
            temp += cur.cnt;
            if ((sum + 1) / 2 <= temp) {
                ans = cur.idx;
                break;
            }
        }

        System.out.println(ans);
    }

    static class Town implements Comparable<Town> {
        long idx;
        long cnt;

        public Town(long idx, long cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Town o) {
            if (this.idx - o.idx < 0) return -1;
            else if (this.idx - o.idx > 0) return 1;
            else return 0;
        }
    }
    
}