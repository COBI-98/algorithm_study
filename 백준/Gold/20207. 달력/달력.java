import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int result;
    static boolean[][] calendar;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int maxday = 0;
        PriorityQueue<Schedule> pq = new PriorityQueue();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            pq.add(new Schedule(start, end));
            maxday = Math.max(maxday, end); 
        }

        calendar = new boolean[N][maxday + 2];

        result = 0;

        while (!pq.isEmpty()) {
            Schedule cur = pq.poll();

            for (int i = 0; i < N; i++) {
                if (calendar[i][cur.start]) {
                    continue;
                }
                for (int j = cur.start; j <= cur.end; j++) {
                    calendar[i][j] = true;
                }
                break;
            }

        }

        int wideStart = 365;
        int wideEnd = 0;
        int height= 0;

        for(int j = 1; j< calendar[0].length; j++){
            boolean stop = true;
            for (int i = 0; i < N; i++) {
                if (calendar[i][j]) {
                    wideEnd = Math.max(wideEnd, j);
                    wideStart = Math.min(wideStart, j);
                    height = Math.max(height, i + 1);
                    stop = false;
                }
            }
            if (stop) {
                result += ((wideEnd - wideStart + 1) * height);
                wideStart = 365;
                wideEnd = 0;
                height = 0;
            }
        }

        System.out.println(result);
    }

    static class Schedule implements Comparable<Schedule> {
        public int start;
        public int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.start == o.start) {
                return o.end - this.end;
            } else {
                return this.start - o.start;
            }
        }
    }
}
