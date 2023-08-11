import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int [] list = new int[N];
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            int[] diff = getDiffListOfPositive(N, list);

            if (diff.length == 1 && diff[0] == 0) {
                System.out.println("INFINITY");
                continue;
            }

            int x = diff[0];
            for (int j = 1; j < diff.length; j++) {
                x = gcd(x, diff[j]);
            }
            System.out.println(x);
        }
    }

    private static int[] getDiffListOfPositive(int N, int[] list) {
        Arrays.sort(list);

        Set<Integer> diffSet = new HashSet<>();

        for (int j = 1; j < N; j++) {
            diffSet.add(list[j] - list[j - 1]);
        }

        int[] diff = new int[diffSet.size()];
        int index = 0;
        for (int diffVal : diffSet) {
            diff[index++] = diffVal;
        }
        return diff;
    }

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    
}