import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static char[] list;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new char[N+1];
        checked = new boolean[N+K];

        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < N; i++) {
            list[i] = str.charAt(i);
        }

        for (int i = 0; i < N; i++) {
            if (list[i] == 'P'){
                int start= outIdxCheck(i-K);
                int end = outIdxCheck2(i+K);
                for (int j = start; j <= end; j++) {
                    if (list[j] == 'H' && !checked[j]) {
                        checked[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int outIdxCheck(int x) {
        if (x < 0){
            x = 0;
        }
        return x;
    }

    private static int outIdxCheck2(int x) {
        if (x >= N){
            x = N-1;
        }
        return x;
    }
}
