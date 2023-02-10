import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int L;
    public static int C;
    public static String[] alphabet;
    public static String[] answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new String[C];
        answer = new String[L];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            String ch = st.nextToken();
            alphabet[i] = ch;
        }

        Arrays.sort(alphabet);

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int x, int depth) {
        if (depth == L) {
            if(alphabetCheck(answer)){
                for (int i = 0; i < L; i++) {
                    sb.append(answer[i]);
                }
                sb.append('\n');   
            }
            return;
        }
        for (int i = x; i < C; i++) {
            answer[depth] = alphabet[i];
            dfs(i + 1, depth + 1);
        }

    }

    public static boolean alphabetCheck(String[] arr) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < L; i++) {
            if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                count1++;
            } else {
                count2++;
            }
        }

        if (count1 >= 1 && count2 >= 2) {
            return true;
        }
        return false;
    }
}
