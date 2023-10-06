import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int firstElement = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {

            st = new StringTokenizer(br.readLine());

            int query = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(query == 1) {
                sb.append(
                            IntStream.iterate(firstElement + (index * (first - 1)), i -> i + index)
                                     .limit(second - first + 1)
                                     .sum()).append("\n");
                continue;
            }

            sb.append(
                        IntStream.iterate(firstElement + (index * (first - 1)), i -> i + index)
                                 .limit(second - first + 1)
                                 .reduce(Main::gcd)
                                 .getAsInt()

            ).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static int gcd(int a, int b) {
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
    
}