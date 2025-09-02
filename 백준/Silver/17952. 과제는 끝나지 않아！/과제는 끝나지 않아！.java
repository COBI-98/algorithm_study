import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Task> s = new Stack<>();
        Task cur;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int category = Integer.parseInt(st.nextToken());

            if (category == 1) {
                int a = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                s.add(new Task(a, t - 1));
                cur = s.pop();

                if (cur.time != 0) {
                    s.add(new Task(cur.score, cur.time));
                } else {
                    ans += cur.score;
                }
            } else {
                if (!s.isEmpty()) {
                    cur = s.pop();
                    cur.time -= 1;
                    if (cur.time != 0) {
                        s.add(new Task(cur.score, cur.time));
                    } else {
                        ans += cur.score;
                    }
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
    
    static class Task {
        int score;
        int time;

        public Task(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}