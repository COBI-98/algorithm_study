import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int X;
    public static int Y;
    public static int Z;
    public static int zCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = getPercent(X,Y);

        System.out.println(binarySearch());
    }

    public static int binarySearch(){
        int ans = -1;
        int left = 0;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getPercent(X + mid, Y + mid) != Z) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
