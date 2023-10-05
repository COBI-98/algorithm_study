import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        Integer[] arr = new Integer[N];

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            return b - a;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            if(pq.size() < M) { 
                pq.offer(arr[i]);
            }else{ 
                pq.offer(pq.poll() + arr[i]);
            }
        }
        
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        while (!pq.isEmpty()){
            pq2.offer(pq.poll());
        }

        System.out.println(pq2.poll());
    }
}