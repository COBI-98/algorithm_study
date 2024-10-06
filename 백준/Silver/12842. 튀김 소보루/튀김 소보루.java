
import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        n -= s;
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m + 1];
        for (int i = 1; i <= m; i++) arr[i] = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int time = 0; n > 0; time++) {
            for (int i = 1; i <= m; i++) {
                if (time % arr[i] == 0) {
                    n--;
                    answer = i;
                    if (n == 0) break;
                }
            }
        }
        bw.write(answer + "");
        bw.close();
    }
}