import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static String[] styleName;
    static int[] styleNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        styleName = new String[N];
        styleNum = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            styleName[i] = st.nextToken();
            styleNum[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int userCheck = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (styleNum[mid] < userCheck) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(styleName[left]).append("\n"); //
        }

        System.out.println(sb);
    }
}
