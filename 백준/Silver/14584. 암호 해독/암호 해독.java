import java.io.*;
import java.util.*;
public class Main {
	public static char [] arr;
	public static String decoding;
	public static int N;
	public static String [] message;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		N = Integer.parseInt(br.readLine());	
		
		message = new String[N];
		for(int i=0; i<N; i++) {
			message[i] = br.readLine();
		}
		
		for(int i=0; i<26;i++) {
			String answer = "";
			for (int j = 0; j < arr.length; j++) {
                arr[j] = (char)('a'+((arr[j]-'a'+1)%26));
            }
			
			decoding = String.valueOf(arr);
			
			if(decodingCheck(decoding)) {
				System.out.print(decoding);
				break;
			}
			
		}
	}
	
	public static boolean decodingCheck(String str) {
		
		for(int i=0; i<N;i++) {
			if(str.contains(message[i])) {
				return true;
			}
		}
		
		return false;
	}
}
