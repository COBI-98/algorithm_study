class Solution {
    public static String [] gatherWord = {"A","E","I","O","U"};
    public static int cnt = 0;
    public static int ans = 0;
    
	public int solution(String word) {
		dfs(0, "", word);
		return ans;
	}
	private static void dfs(int depth, String str, String word) {
		if (depth == 5){
            return;
        }
			
		for (int i = 0; i < gatherWord.length; i++) {
			String wordCheck = str + gatherWord[i];
			cnt++;
			if (wordCheck.equals(word)) {
				ans = cnt;
				return;
			}
			dfs(depth + 1, wordCheck, word);
		}
	}
}