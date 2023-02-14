import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int[] time = new int[3];  // time[0] = 10  , time[1] = 60 , time[2] = 300
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while (N >= 10) {
            if (N >= 300) {
                time[0] = N / 300;
                N = N % 300;
            } else if (N >= 60 && N < 300) {
                time[1] = N / 60;
                N = N % 60;
            } else if (N >= 10 && N < 60) {
                time[2] = N / 10;
                N = N % 10;
            }
        }

        if (N == 0) {
            for (int i = 0; i < time.length; i++) {
                sb.append(time[i] + " ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
