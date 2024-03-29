import java.io.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static int ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ans = 0;
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[w];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i < w - 1; i++) {
            int current = arr[i];
            int leftMax = current;
            int rightMax = current;

            for (int k = i - 1; k >= 0; k--) {
                if (arr[k] > current) {
                    leftMax = Math.max(leftMax, arr[k]);
                }
            }

            for (int k = i + 1; k < w; k++) {
                if (arr[k] > current) {
                    rightMax = Math.max(rightMax, arr[k]);
                }
            }

            if (Math.min(leftMax, rightMax) > current) {
                ans += Math.min(leftMax, rightMax) - arr[i];
            }
        }
        System.out.println(ans);
    }
}