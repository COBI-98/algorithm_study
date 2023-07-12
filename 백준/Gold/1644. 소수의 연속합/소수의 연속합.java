import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static int MAX_RANGE = 4000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[MAX_RANGE + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX_RANGE; i++) {
            if (isPrime[i]){
                for (int j = i * i; j <= MAX_RANGE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isPrime[i]){
                list.add(i);
            }
        }

        int sum;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = list.get(i);

            if (sum > N){
                break;
            }else if (sum == N){
                count++;
                break;
            }

            for (int j = i+1; j < list.size(); j++) {
                sum += list.get(j);

                if (sum > N){
                    break;
                }else if (sum == N){
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
