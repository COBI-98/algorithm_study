import java.io.*;
import java.util.*;

public class Main {
    static class Road {
        int s, e, w;
        public Road (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<Road> list = new ArrayList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (e > d) continue;
            if (e - s <= w) continue;
            
            list.add(new Road(s, e, w));
        }

        Collections.sort(list, new Comparator<Road>(){
            public int compare(Road o1, Road o2) {
                if (o1.s == o2.s) return o1.e - o2.e;
                return o1.s - o2.s;
            }
        });

        int idx = 0, move = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist, 10001);
        dist[0] = 0;
        
        while (move < d) {
            if (idx < list.size()) {
                Road r = list.get(idx);
                if (move == r.s) {
                    dist[r.e] = Math.min(dist[move] + r.w, dist[r.e]);
                    idx++;
                } else {
                    dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                move++;
            }
        }
        System.out.println(dist[d]);
    }
}
