import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static int N , M;
    static boolean check[];
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        for(int i = 0; i < N; i++)
            arr[i] = new ArrayList();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            for(int node : arr[i]) {
                check = new boolean[N];
                check[node] = true;
                dfs(node , 0);
            }
        }

        if(flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }

    public static void dfs(int node , int cnt) {
        if(cnt >= 4) {
            flag = true;
            return;
        }

        for(int number : arr[node]) {
            if(!check[number]) {
                check[number] = true;
                dfs(number , cnt + 1);
            }
        }
        check[node] = false;

    }

}