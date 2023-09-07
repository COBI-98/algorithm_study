import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    static int[][][][] dp = new int[3][3][3][3];
    static String street;
    
    // K의 배수 풀이
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    
        dp[0][0][0][0] = 1;

        street = br.readLine();
    }
    
    private static void solve(){
        
        int tcnt = 0, gcnt = 0, fcnt = 0, pcnt = 0;
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            char x = street.charAt(i);
            if (x == 'T')
                tcnt = (tcnt + 1) % 3;
            else if (x == 'G')
                gcnt = (gcnt + 1) % 3;
            else if (x == 'F')
                fcnt = (fcnt + 1) % 3;
            else if (x == 'P')
                pcnt = (pcnt + 1) % 3;
            ans += dp[tcnt][gcnt][fcnt][pcnt];
            dp[tcnt][gcnt][fcnt][pcnt] += 1;
        }

        System.out.println(ans);
        
    }
}