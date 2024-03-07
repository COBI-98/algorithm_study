class UserSolution {
    public final static int N = 4;
	static int dataCnt;
    static boolean[] checkNum;
    static int[][] failData;
    static int[] num;

    public void doUserImplementation(int guess[]) {
        num = guess;
        dataCnt = 0;
        checkNum = new boolean[10];
        failData = new int[10][6];

        dfs(0);
    }

    static boolean dfs(int n) {
        if (n >= 4) {
            if (!isPossible()) {
                return false;
            }

            Solution.Result result = Solution.query(num);
            if (result.strike == 4) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                failData[dataCnt][i] = num[i];
            }
            failData[dataCnt][4] = result.strike;
            failData[dataCnt][5] = result.ball;
            dataCnt++;

            return false;
        }

        for (int i = 0; i < 10; i++) {
            if (checkNum[i]) {
                continue;
            }
            num[n] = i;
            checkNum[i] = true;

            if (dfs(n + 1)) {
                return true;
            }
            checkNum[i] = false;
        }

        return false;
    }

    static boolean isPossible() {
        for (int i = 0; i < dataCnt; i++) {
            int strike = 0;
            int ball = 0;
            // System.out.println(Arrays.toString(failData[i]));

            for (int j = 0; j < 4; j++) {
                if (failData[i][j] == num[j]) {
                    strike++;
                } else if (checkNum[failData[i][j]]) {
                    ball++;
                }
            }

            if ((failData[i][4] != strike) || (failData[i][5] != ball)) {
                return false;
            }
        }
        return true;
    }
}
