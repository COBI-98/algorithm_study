import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
     
        StringTokenizer st = new StringTokenizer(br.readLine());   
        
        int A = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N-1;i++){
            int B = Integer.parseInt(st.nextToken());
            
            int gcd = calculateGCD(A,B);
            sb.append((A/gcd)+"/"+(B/gcd) + '\n');
        }
        System.out.println(sb);
    }
    
    private static int calculateGCD(int x, int y){
        while(y != 0){
            int target = y;
            y = x % y;
            x = target;
        }  
        return x;
    }
    
}
