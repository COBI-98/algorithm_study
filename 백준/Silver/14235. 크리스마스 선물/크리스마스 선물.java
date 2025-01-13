import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            if(a == 0){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.poll());
                }
            }else{
                for(int j = 0; j < a; j++){
                    queue.add(Integer.parseInt(str.nextToken()));
                }
            }
        }
    }
}