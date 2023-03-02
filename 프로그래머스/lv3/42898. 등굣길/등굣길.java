class Solution {
    public static int [][] street;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        street = new int [n][m];
        for (int[] puddle : puddles){
            street[puddle[1] - 1][puddle[0] - 1] = -1;   
        }

    street[0][0] = 1;

        for (int i = 0; i < n; i++) { // 시작점은 1로 저장
          for (int j = 0; j < m; j++) {

            if(street[i][j] == -1) { // 웅덩이면 0으로 바꾸고 continue
              street[i][j] = 0;
              continue;
            }

            if(i != 0)
              street[i][j] += street[i - 1][j] % 1_000_000_007; 

            if(j != 0)
              street[i][j] += street[i][j - 1] % 1_000_000_007; 
          }
        }

    return street[n - 1][m - 1] % 1_000_000_007;
  }
}