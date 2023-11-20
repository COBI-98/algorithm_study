import java.util.*;

class Solution {

    static List<Player>[] adjList;
    static int[] mentor;

    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;

        mentor = new int[k + 1];
        adjList = new List[k + 1];

        for (int i = 0; i <= k; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] req : reqs) {
            int startTime = req[0];
            int duration = req[1];
            int type = req[2];

            adjList[type].add(new Player(startTime, startTime + duration));
        }


        int[][] waitTimeForEachTime = new int[k + 1][n + 1];
        for (int type = 1; type <= k; type++) {

            if (adjList[type].size() == 0) {
                continue;
            }

            for (int counselors = 1; counselors <= (n-k) +1; counselors++) {

                int waitTime = calculationTime(adjList[type], counselors);
                waitTimeForEachTime[type][counselors] = waitTime;
            }
        }

        Arrays.fill(mentor, 1);

        int remainCounselorNumber = n - k;

        while (remainCounselorNumber-- > 0) {
            int maxReduceTime = 0;
            int correspondingType = 0;

            for (int type = 1; type < k + 1; type++) {
                int currentCounselorsByType = mentor[type];

                int waitingTimeOfCurrentCounselors = waitTimeForEachTime[type][currentCounselorsByType];

                int next = waitTimeForEachTime[type][currentCounselorsByType + 1];

                int reduceWaitingTime = Math.abs(waitingTimeOfCurrentCounselors - next);

                if (reduceWaitingTime >= maxReduceTime) {
                    maxReduceTime = reduceWaitingTime;
                    correspondingType = type;
                }
            }

            if (maxReduceTime == 0) break;

            mentor[correspondingType]++;
        }

        for (int type = 1; type < k + 1; type++) {

            if (adjList[type].size() == 0) continue;

            int counselors = mentor[type];
            
            answer += waitTimeForEachTime[type][counselors];
        }
        
        return answer;
    }

    private int calculationTime(List<Player> typeTime, int counselorNumber) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int waitTime = 0;

        for (Player cur : typeTime) {
            if (pq.isEmpty() || pq.size() < counselorNumber) {
                pq.add(cur.play);
            } else {
                int earlyConsultEndTime = pq.poll();

                if (cur.start < earlyConsultEndTime) {
                    waitTime += (earlyConsultEndTime - cur.start);
                    pq.add(earlyConsultEndTime + (cur.play - cur.start));
                } else {
                    pq.add(cur.play);
                }
            }
        }
        return waitTime;
    }

    static class Player{
        int start;
        int play;

        public Player(int start, int play) {
            this.start = start;
            this.play = play;
        }
    }
}