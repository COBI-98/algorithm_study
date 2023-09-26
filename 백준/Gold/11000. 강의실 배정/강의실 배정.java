import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Lecture[] arr = new Lecture[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0].end);
        for(int i = 1; i < n; i++){
            if(!pq.isEmpty()){
                if(arr[i].start >= pq.peek())
                    pq.poll();

                pq.add(arr[i].end);
            }
        }

        System.out.println(pq.size());

    }
    
    static class Lecture implements Comparable<Lecture>{
        int start;
        int end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }    

        @Override
        public int compareTo(Lecture o){
            if(this.start == o.start)
                return this.end - o.end;
            else
            return this.start - o.start;
        }
    }
    
}
    