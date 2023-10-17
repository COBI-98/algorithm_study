import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int index = 0;
            for (Integer numInDq : dq) {
                if (numInDq == num) {
                    break;
                }
                index++;
            }

            int left = index;
            int right = dq.size() - index;

            if (left < right) {
                while (left-- > 0) {
                    int first = dq.pollFirst();
                    dq.offerLast(first);
                    cnt++;
                }
                dq.pollFirst();
            } else {
                while (right-- > 0) {
                    int last = dq.pollLast();
                    dq.offerFirst(last);
                    cnt++;
                }
                dq.pollFirst();
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}