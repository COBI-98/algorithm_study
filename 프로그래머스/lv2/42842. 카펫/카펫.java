class Solution {
    public static int [] answer = new int[2];
    public static int size;
    public int[] solution(int brown, int yellow) {
        size = brown + yellow;
        
        for (int i = 3; i < size; i++) {
            int j = size / i;
            
            if (size % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);
                
                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}