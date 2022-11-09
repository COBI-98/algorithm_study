package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] house;
    static int[][] cost;
    static int N ;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        house = new int[N][3];
        cost = new int[N][3];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.hasMoreTokens()) {
                house[i][0] = Integer.parseInt(st.nextToken());
                house[i][1] = Integer.parseInt(st.nextToken());
                house[i][2] = Integer.parseInt(st.nextToken());
            }
        }

        cost[0][0] = house[0][0];
        cost[0][1] = house[0][1];
        cost[0][2] = house[0][2];


        System.out.println(Math.min(Math.min(rgb(N-1,0), rgb(N-1,1)), rgb(N-1,2)));
    }
    public static int rgb(int N, int color) {

        if(cost[N][color] == 0) {
            if(color == 0 )
                return cost[N][color] = Math.min(rgb(N-1,1), rgb(N-1,2)) + house[N][color];
            if(color == 1 )
                return cost[N][color] = Math.min(rgb(N-1,0), rgb(N-1,2)) + house[N][color];
            if(color == 2 )
                return cost[N][color] = Math.min(rgb(N-1,0), rgb(N-1,1)) + house[N][color];
        }

        return cost[N][color];

    }
}