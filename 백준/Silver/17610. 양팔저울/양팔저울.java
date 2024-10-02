import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    static boolean[] weights;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        
        int maxWeight = Arrays.stream(input).sum();
        weights = new boolean[maxWeight + 1];
        
        solve(0, 0);
        
        int result = 0;
        for (int i = 1; i < weights.length; i++) {
            if (!weights[i]) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void solve(int depth, int sum) {
        if (sum > 0) {
            weights[sum] = true;
        }
        if (depth == input.length) {
            return;
        }
        solve(depth + 1, sum + input[depth]);
        solve(depth + 1, sum - input[depth]);
        solve(depth + 1, sum);
    }
}