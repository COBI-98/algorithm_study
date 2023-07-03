import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add((Integer.parseInt(br.readLine())));
        }

        Long num = 0L;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            num += a + b;
            pq.add(a+b);
        }

        System.out.println(num);

    }

}
