import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int [] arr;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        backT(0);

        System.out.println(sb);
    }

    public static void backT(int depth){
        if (depth == N){
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append('\n');
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                arr[depth] = i+1;
                visited[i] = true;
                backT(depth+1);
                visited[i] = false;
            }

        }
    }
}
