import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    static int [] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
     
        arr = new int[N];
        for(int i=0; i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int totalGCD = arr[1] - arr[0];
        
        for(int i=2; i<N;i++){
            totalGCD = calculateGCD(totalGCD, arr[i] - arr[i-1]);
        }
        
        for(int i=2; i<=totalGCD;i++){
            if(totalGCD % i == 0){
                sb.append(i + " ");
            }
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
