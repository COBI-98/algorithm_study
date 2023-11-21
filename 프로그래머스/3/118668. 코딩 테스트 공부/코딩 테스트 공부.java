import java.util.*;

class Solution {

    static int INF = 987654321;
    static int[][] dp;
    static int maxAlp = Integer.MIN_VALUE;
    static int maxCop = Integer.MIN_VALUE;

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        dp = new int[151][151];

        for (int i = 0; i < 151; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        dp[alp][cop] = 0;

        Queue<Study> queue = new LinkedList<>();
        queue.add(new Study(alp, cop, 0));

        while (!queue.isEmpty()) {

            Study cur = queue.poll();

            int curAlp = cur.alp;
            int curCop = cur.cop;
            int curCost = cur.cost;

            if (curAlp == maxAlp && curCop == maxCop) {
                dp[curAlp][curCop] = Math.min(dp[curAlp][curCop], curCost);
            } else {

                for (int i = 0; i < problems.length; i++) {

                    int want_alp = problems[i][0];
                    int want_cop = problems[i][1];
                    int increase_alp = problems[i][2];
                    int increase_cop = problems[i][3];
                    int cost = problems[i][4];

                    if (curAlp >= want_alp && curCop >= want_cop) {

                        int nextAlp = curAlp + increase_alp;
                        int nextCop = curCop + increase_cop;

                        if (nextAlp > maxAlp) {
                            nextAlp = maxAlp;
                        }

                        if (nextCop > maxCop) {
                            nextCop = maxCop;
                        }

                        if (dp[nextAlp][nextCop] > curCost + cost) {
                            dp[nextAlp][nextCop] = curCost + cost;
                            queue.add(new Study(nextAlp, nextCop, curCost + cost));
                        }
                    }
                }

                if (curAlp < maxAlp && dp[curAlp + 1][curCop] > curCost + 1) {
                    dp[curAlp + 1][curCop] = curCost + 1;
                    queue.add(new Study(curAlp + 1, curCop, curCost + 1));
                }
                if (curCop < maxCop && dp[curAlp][curCop + 1] > curCost + 1) {
                    dp[curAlp][curCop + 1] = curCost + 1;
                    queue.add(new Study(curAlp, curCop + 1, curCost + 1));
                }
            }
        }

        return dp[maxAlp][maxCop];
    }

    private class Study {
        int alp;
        int cop;
        int cost;

        public Study(int curAlp, int cop, int cost) {
            this.alp = curAlp;
            this.cop = cop;
            this.cost = cost;
        }
    }
}