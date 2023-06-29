import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    static int M;
    static int [] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int [N+1];
        
        for(int i=0;i<N+1;i++){
            arr[i] = i;
        } 
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int isUnion = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(isUnion == 0) {
                union(a,b);
            }else {
                if(find(a)==find(b)){
                      sb.append("YES"+"\n");   
                }
                else sb.append("NO" + "\n");
            }
        }
        System.out.println(sb);
        
    }
    
    public static int find(int x) {
        if(arr[x]==x) return x;
        
        return arr[x] = find(arr[x]);
    }
    
    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot != bRoot) arr[aRoot] = bRoot;
        
    }
    
}
