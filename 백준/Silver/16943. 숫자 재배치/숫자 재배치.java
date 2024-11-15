import java.io.*;
import java.util.*;

public class Main {
 
    private static String A;
    private static int B, lenA, maxRlt;
    private static int[] nums;
    private static boolean[] visited;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        lenA = A.length();
        nums = new int[lenA];
        for (int i = 0; i < lenA; i++) {
            nums[i] = A.charAt(i) - 48;
        }
        
        sb = new StringBuilder();
        maxRlt = 0;
        visited = new boolean[lenA];
        recur(0);
        if (maxRlt == 0) System.out.println(-1);
        else System.out.println(maxRlt);
    }
    
    private static void recur(int depth) {
        
        if (depth == lenA) {
            int tmp = Integer.parseInt(sb.toString());
            if (tmp < B) {
                maxRlt = Math.max(maxRlt, tmp);
            }
            return;
        }
        for (int i = 0; i < lenA; i++) {
            
            if (depth == 0 && nums[i] == 0) continue;
            if (visited[i]) continue;
            sb.append(nums[i]);
            visited[i] = true;
            recur(depth + 1);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}