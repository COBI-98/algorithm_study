import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class lecture {
        int p;
        int d;

        public lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }

    public static int n;
    public static boolean [] check;
    public static PriorityQueue<lecture> queue = new PriorityQueue<>((o1, o2) -> {
        if(o1.p == o2.p) {
            return o1.d - o2.d;
        }
        return o2.p - o1.p;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        check = new boolean[10001];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A =Integer.parseInt(st.nextToken());
            int B =Integer.parseInt(st.nextToken());
            queue.offer(new lecture(A,B));
        }

        int sum = 0;
        while(!queue.isEmpty())
        {
            lecture cur = queue.poll();
            for(int i = cur.d; i > 0; --i)
            {
                if(!check[i])
                {
                    check[i] = true;
                    sum += cur.p;
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
