import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;

class Solution{
    public static int N;
    public static int test_case;
    public static int [] arr;
    public static long answer;
    public static int count = 1;
    
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(br.readLine());
        
        while(test_case-- > 0){
            N = Integer.parseInt(br.readLine());
            arr = new int [N];
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int maxSale = arr[N-1];
            
            for(int i=N-2; i >= 0; i--){
            	if(maxSale < arr[i]){
                	maxSale = arr[i];
                }else{
                	answer += maxSale - arr[i];
                }
            }
            
            System.out.println("#"+count+" "+answer);
            count++;
		}
	}
}