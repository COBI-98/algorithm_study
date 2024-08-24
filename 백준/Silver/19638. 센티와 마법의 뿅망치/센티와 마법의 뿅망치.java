import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int h = stoi.apply(st.nextToken());
        int t = stoi.apply(st.nextToken());
        PriorityQueue<Integer> heights = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =  0 ; i < n ; i++){
            int num = stoi.apply(br.readLine());
            heights.add(num);
        }
        int cnt = 0;
        while(h <= heights.peek() && cnt < t){
             int height = heights.poll();
             height = Math.max(1, height/2);
             heights.add(height);
             cnt++;
        }
        if(h > heights.peek() && cnt <= t){
            System.out.println("YES");
            System.out.println(cnt);
        }else{
            System.out.println("NO");
            System.out.println(heights.peek());
        }
    }
}