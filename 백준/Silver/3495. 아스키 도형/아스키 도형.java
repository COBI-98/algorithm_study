import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        double count = 0;
        
        for(int i=0 ; i<H ; i++) {
            String str = br.readLine();
            int check = 0;
            
            for(int j=0 ; j<W ; j++) {
                char ch = str.charAt(j);
                
                if(ch=='/' || ch=='\\') {
                    count += 0.5;
                    check++;
                }
                if(check%2==1 && ch=='.')
                    count++;
            }
        }
        
        System.out.println((int)count);
    }
}