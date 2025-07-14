import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        int[][] field = new int[6][2];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            field[i][0] = Integer.parseInt(st.nextToken());
            field[i][1] = Integer.parseInt(st.nextToken());
        }
        int mxW = 0;
        int mxH = 0;
        int mxWIdx = -1;
        int mxHIdx = -1;

        for(int i = 0; i < 6; i++){
            int now = field[i][1];
            if(field[i][0] == 1 || field[i][0] == 2){
                if(now > mxW){
                    mxW = now;
                    mxWIdx = i;
                }
            }
            else{
                if(now > mxH){
                    mxH = now;
                    mxHIdx = i;
                }
            }
        }

        int area = mxW * mxH;
        int mnW = field[(mxHIdx + 3)%6][1];
        int mnH = field[(mxWIdx + 3)%6][1];
        area -= mnW * mnH;
        System.out.println(area * K);

    }
}