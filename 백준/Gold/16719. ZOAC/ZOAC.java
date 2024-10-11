import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static String input;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		visited = new boolean[input.length()];
		find(0,input.length()-1);
		System.out.println(sb.toString().trim());
	}
	
	static void find(int start, int end) {
		if(start>end) return;
		
		int idx = start;
		int minV = input.charAt(start); 
        
		for(int i =start; i<=end; i++) {
			if(input.charAt(i)<minV) {
				minV = input.charAt(i);
				idx = i;
			}
		}
		visited[idx] = true;
		for (int i =0; i<input.length(); i++) {
			if(visited[i]) {
				sb.append(input.charAt(i));
			}
		}
		sb.append("\n");
		find(idx+1, end);
		find(start,idx-1);
	}
}