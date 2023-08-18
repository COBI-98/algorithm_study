import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static boolean checked[] = new boolean[26];
    static String[] wordList;
    static int[] numbers;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wordList = new String[N];

        if (K < 5) {
            System.out.println(0);
        } else if (K == 26) {
            System.out.println(N);
        } else {
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                wordList[i] = str.substring(4, str.length() - 4);
            }

            checked['a' - 97] = true;
            checked['n' - 97] = true;
            checked['t' - 97] = true;
            checked['i' - 97] = true;
            checked['c' - 97] = true;
            numbers = new int[K - 5];
            combination(0, 0);

            System.out.println(max);
        }
    }

    private static void combination(int idx, int start) {
        if (idx == K - 5) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                boolean isValid = true;
                for (int j = 0; j < wordList[i].length(); j++) {
                    if (!checked[wordList[i].charAt(j) - 97]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!checked[i]) {
                checked[i] = true;
                combination(idx + 1, i + 1);
                checked[i] = false;
            }

        }
    }

}