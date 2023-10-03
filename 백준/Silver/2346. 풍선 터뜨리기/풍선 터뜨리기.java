import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= N; i++){
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while(true){
            if(deque.size() ==1){
                break;
            }
            Balloon tmp = deque.pollFirst();
            int idx = tmp.idx;
            sb.append(tmp.num).append(" ");

            if(idx > 0){
                idx = idx -1;
                while(idx-- > 0){
                    deque.addLast(deque.pollFirst());
                }
            } else {
                while(idx++ < 0){
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.poll().num);
        System.out.println(sb);
    }

    static class Balloon{
        int num;
        int idx;

        Balloon(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
}