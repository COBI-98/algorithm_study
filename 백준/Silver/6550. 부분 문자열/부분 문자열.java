import java.io.*;
import java.util.*;

public class Main {
	
	public static String str;
	public static String s;
	public static String t;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while((str = br.readLine()) != null) {
			
			
			StringTokenizer st = new StringTokenizer(str);
			Queue<String> q = new LinkedList<>();
			
			s = st.nextToken();
			t = st.nextToken();
			int count = 0;
			
			for(int i=0; i < s.length(); i++) {
				q.add(String.valueOf(s.charAt(i)));
			}
			
			for(int i=0; i< s.length(); i++) {
				String message = q.poll();
				for(int j=0; j< t.length(); j++) {
					if(message.equals(String.valueOf(t.charAt(j)))) {
						t = t.substring(j+1,t.length());
						count++;
						
						break;
					}
				}
			}
			
			if(s.length() == count) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
			
			
		}
		
	}
}
