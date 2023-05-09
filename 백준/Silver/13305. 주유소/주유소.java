import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long [] street;
    static long [] cities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        street = new long [N-1];
        cities = new long [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1;i++){
            street[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            cities[i] = Long.parseLong(st.nextToken());
        }
        
        
        System.out.println(gasStation(N));
    }

    public static long gasStation(int x){
        long sum= 0;
        long min = cities[0]; 
        for(int i=0;i<x-1;i++){
            if(min > cities[i]){
                min = cities[i];
            }
            sum += (min * street[i]);
        }
        
        return sum;
    }
}
