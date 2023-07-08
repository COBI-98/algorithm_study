import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long x = Long.parseLong(st.nextToken());
        Long y = Long.parseLong(st.nextToken());

        Long sum = x + y;
        Long lastNum = 1L;
        while (true){

            if (sum < (lastNum * (lastNum+1)) / 2 ){
                System.out.println(-1);
                return;
            }else if(sum == (lastNum * (lastNum+1)) / 2 ){
                break;
            }else{
                lastNum++;
            }
        }

        int cnt = 0;
        while (x>0){
            x -= lastNum--;
            cnt++;
        }

        System.out.println(cnt);
    }
}
