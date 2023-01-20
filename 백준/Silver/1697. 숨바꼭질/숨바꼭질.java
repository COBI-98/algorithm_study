import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int K;
    public static int[] count;
    public static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = new int[100001];

        count[N] = 1;
        queue.add(N);

        if (N == K){
            System.out.println(0);
        }else{
            bfs();
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = temp * 2;
                } else if(i == 1){
                    next = temp + 1;
                } else{
                    next = temp - 1;
                }
                
                if (next == K) {
                    System.out.println(count[temp]);
                    return;
                }

                if (next >= 0 && next < count.length && count[next] == 0) {
                    queue.add(next);
                    count[next] = count[temp] + 1;
                }
            }

        }

    }


}
