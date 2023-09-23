import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] currentParking = new int[N+1];
        int[] carWeight = new int[M+1]; 
        int[] parkingWeight = new int[N+1];

        int sum = 0;

        for (int i=1; i<=N; i++) {
            parkingWeight[i] = Integer.parseInt(br.readLine());
        }
        for (int i=1; i<=M; i++) {
            carWeight[i] = Integer.parseInt(br.readLine());
        }
        Queue<Integer> queue = new LinkedList<>();

        out: for (int i=0; i<2*M; i++) {
            int car = Integer.parseInt(br.readLine());
            if (car>0) {
                for (int j = 1; j<N+1; j++) {
                    if (currentParking[j] == 0) {
                        currentParking[j] = car;
                        continue out;
                    }
                }
                queue.offer(car);
            } 
            else {
                for (int j=1; j<N+1; j++) {
                    if (currentParking[j] == car * (-1)) {
                        currentParking[j] = 0;
                        sum += parkingWeight[j] * carWeight[car * (-1)];
                        if (!queue.isEmpty()) currentParking[j] = queue.poll();
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}