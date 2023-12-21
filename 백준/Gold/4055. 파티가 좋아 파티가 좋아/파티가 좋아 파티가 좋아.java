import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final String PARTY_TEST_RESULT_FORMAT = "On day %d Emma can attend as many as %d parties.";
    static int p;
    static int s;
    static int e;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int day = 1;

        while((p = Integer.parseInt(br.readLine())) != 0 ? true : false){
            PriorityQueue<Time> pq = new PriorityQueue<>();
            int n = 0;

            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                pq.add(new Time(s, e));
            }

            visited = new int[25];

            while(!pq.isEmpty()){
                Time cur = pq.poll();

                for (int possibleTime = cur.s; possibleTime < cur.e; possibleTime++) {
                    if (visited[possibleTime] < 2){
                        visited[possibleTime]++;
                        n++;
                        break;
                    }
                }

            }

            sb.append(String.format(PARTY_TEST_RESULT_FORMAT, day, n))
                    .append("\n");
            day++;
        }

        System.out.println(sb);
    }

    static class Time implements Comparable<Time> {
        int s;
        int e;
        int diff;


        public Time(int s, int e) {
            this.s = s;
            this.e = e;
            this.diff = createDiff(s,e);
        }

        private int createDiff(int s, int e) {
            return e - s;
        }

        @Override
        public int compareTo(Time o) {
            if (this.diff < o.diff) {
                return -1;
            } else if (this.diff == o.diff) {
                return 0;
            } else {
                return 1;
            }
        }

    }
}
