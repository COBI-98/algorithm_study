import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;  //
    public static int K;
    public static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while (true) {

            int numCheck = N+answer;
            int count = 0;

            while (numCheck > 0) {
                if (numCheck%2 != 0){
                    count++;
                }
                numCheck = numCheck/2;
            }

            if (count <= K){
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
