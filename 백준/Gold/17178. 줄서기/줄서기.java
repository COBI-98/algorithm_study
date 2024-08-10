import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final String ENJOY_SHOW_SUCCESS = "GOOD";
    static final String ENJOY_SHOW_FAIL = "BAD";
    static int M;
    static PriorityQueue<Table> pq;
    static Table[][] table;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        table = new Table[M][5];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; ++j) {
                String[] str = st.nextToken().split("-");
                Table t = new Table(str[0].charAt(0), Integer.parseInt(str[1]));
                table[i][j] = t;
                pq.offer(t);
            }
        }

        System.out.println(solution());

    }

    private static String solution() {

        Stack<Table> stack = new Stack();

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (isSame(table[i][j], pq.peek()))
                    pq.poll();
                else if (!stack.isEmpty() && isSame(pq.peek(), stack.peek())) {
                    stack.pop();
                    pq.poll();
                    --j;
                } else {
                    stack.add(table[i][j]);
                }
            }
        }

        while (!pq.isEmpty() && !stack.isEmpty()) {
            if (isSame(pq.peek(), stack.peek())) {
                pq.poll();
                stack.pop();
            } else
                return ENJOY_SHOW_FAIL;
        }

        return ENJOY_SHOW_SUCCESS;
    }

    private static boolean isSame(Table t1, Table t2) {
        if (t1.c == t2.c && t1.n == t2.n)
            return true;
        return false;
    }

    static class Table implements Comparable<Table> {
        char c;
        int n;

        public Table(char c, int n) {
            this.c = c;
            this.n = n;
        }

        @Override
        public int compareTo(Table o) {
            if (this.c == o.c)
                return this.n - o.n;
            return this.c - o.c;
        }

    }

}