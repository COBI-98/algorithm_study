import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] A;
    public static int B;
    public static long countB;
    public static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(assistantManager(generalManager(B), C) +countB);
    }

    public static int[] generalManager(int x) {
        int[] copyA = A;
        countB = 0;
        for (int i = 0; i < N; i++) {
            copyA[i] = A[i] - x;
            countB++;
        }

        return copyA;
    }

    public static long assistantManager(int[] copyA, long C) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (copyA[i] > 0) {
                double count = (double) copyA[i] / C;
                int countC = (int) Math.ceil(count);
                sum = sum + countC;
            }
        }

        return sum;
    }
}