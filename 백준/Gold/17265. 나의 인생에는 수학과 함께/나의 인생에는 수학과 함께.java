import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dRow = {0, 1};
    static int[] dCol = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                char tmp = st.nextToken().charAt(0);
                map[i][j] = tmp;
            }
        }

        Queue<Point> q = new LinkedList<>();
        String tmpStr = String.valueOf(map[0][0] - '0');
        q.add(new Point(0, 0, tmpStr));
        ArrayList<String> resultList = new ArrayList<>();

        while (!q.isEmpty()) {
            Point now = q.poll();

            if(now.row == N - 1 && now.col == N - 1){
                resultList.add(now.result);
                continue;
            }

            for(int i = 0; i < 2; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow >= N || nextCol >= N) continue;

                q.add(new Point(nextRow, nextCol, now.result + map[nextRow][nextCol]));
            }
        }

       
        ArrayList<Integer> resultValues = new ArrayList<>();
        for(int i = 0; i < resultList.size(); i++){
            String resultStr = resultList.get(i);
            int resultValue = calc(resultStr);
            resultValues.add(resultValue);
        }

        Collections.sort(resultValues);
        System.out.println(resultValues.get(resultValues.size() - 1) + " " + resultValues.get(0));
    }

    public static int calc(String str){
        int result = str.charAt(0) - 48;
        for(int i = 1; i < str.length(); i+=2){
            char op = str.charAt(i);
            int ops = str.charAt(i + 1) - 48;

            if(op == '+'){
                result = result + ops;
            }
            else if(op == '-'){
                result = result - ops;
            }
            else if(op == '*'){
                result = result * ops;
            }
        }
        return result;
    }
    
    static class Point{
        int row, col;
        String result;
        public Point(int row, int col, String result){
            this.row = row;
            this.col = col;
            this.result = result;
        }
    }
}