import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // [ ] 스카이라인의 윤곽이 드러나면 최소한의 빌딩이있다.

    static int n;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int [50_002];
        for (int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = y;
        }

        System.out.println(solve());;
    }

    private static int solve() {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                answer++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == arr[i]){
                continue;
            }

            stack.push(arr[i]);
        }

        return answer;
    }

}
