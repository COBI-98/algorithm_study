import java.io.*;
import java.util.*;

class Solution {

    static int[] answer = new int[4];
    static int graphCnt = 0;
    static int[] in;
    static int[] out;

    public int[] solution(int[][] edges) {
        init(edges);
        solve(edges);
        return answer;
    }
    
    private static void init(int[][] edges){
        in = new int[1000001];
        out = new int[1000001];

        for (int[] edge : edges) {
            in[edge[1]]++;
            out[edge[0]]++;
        }
    }
    
    private static void solve(int[][] edges){
        for (int i = 1; i <= 1000000; i++) {
            if (in[i] == 0 && out[i] >= 2) {
                graphCnt = out[i];
                answer[0] = i;
            }
            else if (in[i] >= 1 && out[i] == 0) answer[2]++;
            else if (in[i] >= 2 && out[i] == 2) answer[3]++;
        }

        answer[1] = graphCnt - (answer[2] + answer[3]);
    }
}