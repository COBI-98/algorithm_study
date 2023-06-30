import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N <= 2){
            System.out.println("0");
        }else if (N == 3){
            System.out.println("1");
        }else{
            int res = 2;
            int val = 2;

            for (int i = 5; i <= N; i++) {
                res += val;
                if (i % 2 == 0){
                    val++;
                }
            }

            System.out.println(res);
        }

    }
}
