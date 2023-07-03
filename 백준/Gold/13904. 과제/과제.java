import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean [] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.w == o2.w){
                return o1.d - o2.d; // 점수가 같다면 날짜 빠른순
            }
            return o2.w - o1.w; // 점수 정렬
        });

        checked = new boolean[1001];
        StringTokenizer st ;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(d,w));
        }

        Long sum = 0L;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for (int i = cur.d; i > 0; --i) { // 기간내 풀수있다면 체크
                if (!checked[i]){
                    checked[i] = true;
                    sum += cur.w;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    static class Node{
        int d;
        int w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
}
