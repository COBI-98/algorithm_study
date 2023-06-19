import java.util.*;
class Solution {
    static class Cos{
        int idx;
        int v;
        public Cos(int idx, int v){
            this.idx = idx;
            this.v = v;
        }
    }
    static List<List<Cos>> arr = new ArrayList<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        for(int i=0;i<n+1;i++){
            arr.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int w = path[2];

            if (isGate(s, gates) || isSummit(e, summits)) {
                arr.get(s).add(new Cos(e, w));
            } else if (isGate(e, gates) || isSummit(s, summits)) {
                arr.get(e).add(new Cos(s, w));
            } else {
                arr.get(s).add(new Cos(e, w));
                arr.get(e).add(new Cos(s, w));
            }
        }

        return dijkstra(n, gates, summits);
    }

    private static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Cos> qu = new LinkedList<>();
        int[] INF = new int[n + 1];

        Arrays.fill(INF, Integer.MAX_VALUE);

        for (int gate : gates) {
            qu.add(new Cos(gate, 0));
            INF[gate] = 0;
        }

        while (!qu.isEmpty()) {
            Cos cur = qu.poll();

            // 현재의 가중치가 저장된 가중치보다 커서 최소 갱신이 되지 않을 때 스킵
            if(cur.v > INF[cur.idx]) continue;

            for (int i = 0; i < arr.get(cur.idx).size(); i++) {
                Cos nn = arr.get(cur.idx).get(i);

                // 최소 갱신
                int dis = Math.max(INF[cur.idx], nn.v);
                if (INF[nn.idx] > dis) {
                    INF[nn.idx] = dis;
                    qu.add(new Cos(nn.idx, dis));
                }
            }
        }

        int mn = Integer.MAX_VALUE; 
        int mw = Integer.MAX_VALUE; 

        Arrays.sort(summits);

        for (int summit : summits) {
            if (INF[summit] < mw) {
                mn = summit;
                mw = INF[summit];
            }
        }

        return new int[]{mn, mw};
    }

    private static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }

    private static boolean isSummit(int num, int[] submits) {
        for (int submit : submits) {
            if (num == submit) return true;
        }
        return false;
    }
}