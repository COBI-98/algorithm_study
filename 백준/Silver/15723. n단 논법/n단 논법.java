import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class Main {
    private static final int SIZE = 26;
    private static final char TRUE = 'T';
    private static final char FALSE = 'F';
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        boolean[][] map = new boolean[SIZE][SIZE];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            char start = command.charAt(0);
            char end = command.charAt(5);
            map[start - 'a'][end - 'a'] = true;
        }
        n = stoi.apply(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            char start = command.charAt(0);
            char end = command.charAt(5);
            if(isRight(start-'a',end-'a',map)){
                System.out.println(TRUE);
            }else{
                System.out.println(FALSE);
            }
        }
    }

    private static boolean isRight(int start, int end, boolean[][] map) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[SIZE];
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == end){
                return true;
            }
            for(int i = 0 ; i < SIZE ; i++){
                if(!visited[i] && map[now][i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return false;
    }
}