import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String input[] = br.readLine().split("");
            System.out.println(solve(input));
        }
    }

    private static String solve(String[] input) {
        int target_idx = INF;
        int change_idx = INF;
        int prev = input[input.length-1].charAt(0)-'0';
        for(int i=input.length-2;i>=0;i--){
            int now = input[i].charAt(0)-'0';
            if(now < prev ){
                change_idx = i;
                break;
            }
            prev = now;
        }
        
        if(change_idx != INF){
            int change_value = input[change_idx].charAt(0)-'0';
            for(int i=input.length-1;i>change_idx;i--){
                int now = input[i].charAt(0) - '0';
                if(now > change_value) {
                    target_idx = i;
                    break;
                }
            }}
        
        if(change_idx != INF && target_idx != INF){
            String temp = input[target_idx];
            input[target_idx] = input[change_idx];
            input[change_idx] = temp;
            Arrays.sort(input, change_idx+1, input.length);
        }
        
        StringBuilder sb= new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }
        return sb.toString();
    }
}