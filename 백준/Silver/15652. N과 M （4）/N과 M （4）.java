import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int [] arr;
    public static boolean [] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        NMBacktracking4(1,0);
        System.out.println(sb);
    }

    public static void NMBacktracking4(int sort,int depth){
        if(depth == M){
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = sort; i <= N; i++) {
            arr[depth] = i;
            NMBacktracking4(i,depth+1);
        }
    }
}
