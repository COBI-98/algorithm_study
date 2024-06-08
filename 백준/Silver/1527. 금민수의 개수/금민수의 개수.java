import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a;
    static int b;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        dfs(0);
        System.out.println(answer);

    }

    private static void dfs(long num) {
        if (num > b) {
            return;
        }
        
        if (num >= a && num <= b) {
            answer++;
        }

        dfs(num * 10 + 4);
        dfs(num * 10 + 7);
    }
}