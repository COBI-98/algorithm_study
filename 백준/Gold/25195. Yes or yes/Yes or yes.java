import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static boolean[] isExist;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        init();
        solve(1, false);
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        flag = true;
        isExist = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++){
            int t = Integer.parseInt(st.nextToken());
            isExist[t] = true;
        }
    }

    public static void solve(int num, boolean gom){
        if(list[num].isEmpty()){
            if(!gom && !isExist[num]){
                flag = false;
            }
        }
        if(!flag){
            return;
        }
        for(int i=0; i<list[num].size(); i++){
            int next = list[num].get(i);
            if(isExist[num]){
                solve(next, true);
            }else{
                solve(next, gom);
            }
        }
    }

    private static void printResult() {
        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("yes");
        }
    }
}