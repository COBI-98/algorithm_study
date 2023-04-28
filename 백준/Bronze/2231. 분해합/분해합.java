import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
		// 자릿수의 길이를 알기위해 일단 문자열로 입력받는다.
		String str_N = br.readLine();
 
		int N_len = str_N.length();
 
		int N = Integer.parseInt(str_N);
		int result = 0;
 
		
		for(int i = (N - (N_len * 9)); i < N; i++) {
			int number = i;
			int sum = 0;	
			
			while(number != 0) {
				sum += number % 10;	
				number /= 10;
			}
			
			if(sum + i == N) {
				result = i;
				break;
			}
			
		}
 
		System.out.println(result);
	}
 
}