import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N][2];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

    }
    
    private static void solve(){
        // 작품 본상
        Arrays.sort(arr, (e1, e2) -> {
            if(e1[1] == e2[1]) return e2[0] - e1[0];
            else return e2[1] - e1[1];
        });
        
        long max = 0;
        for(int i=0; i<K; i++){
            max += arr[i][0];
        }

        int[][] remained = new int[N-K][2];
        
        for(int i=0; i<N-K; i++){
            remained[i][0] = arr[i+K][0];
            remained[i][1] = arr[i+K][1];
        }

        // 특별상
        Arrays.sort(remained, (e1, e2) ->{
            if(e1[0] == e2[0]) return e2[1] - e1[1];
            else return e2[0] - e1[0];
        });

        for(int i=0; i<M; i++){
            max += remained[i][0];
        }
        
        System.out.print(max);
    }
    
}