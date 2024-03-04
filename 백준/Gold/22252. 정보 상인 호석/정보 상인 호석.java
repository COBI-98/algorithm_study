import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        HashMap<String, PriorityQueue<Long>> map = new HashMap<>();
        long ans = 0;

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int queryNum = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if (queryNum == 1) {
                for (int i = 0; i < count; i++) {
                    if (!map.containsKey(name)) {
                        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.offer(Long.parseLong(st.nextToken()));
                        map.put(name, pq);
                    } else {
                        map.get(name).offer(Long.parseLong(st.nextToken()));
                    }
                }
            } else {
                if (map.get(name) == null) {
                    continue;
                }
                while (!map.get(name).isEmpty() && count > 0) {
                    ans += map.get(name).poll();
                    count--;
                }
            }
        }
        bw.append(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}