import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{

    public static int N; // 자연수 N
    public static int M; // 자연수 M

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        NMBackTracking(0);
        System.out.println(sb);
    }

    public static void NMBackTracking(int depth){
        if (depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {

            // 만약 해당 노드(값)을 방문하지 않았다면?
            if (!visit[i]) {
                visit[i] = true; // 해당 노드를 방문상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i + 1 값 저장
                NMBackTracking(depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
                visit[i] = false;
            }
        }

    }


}
