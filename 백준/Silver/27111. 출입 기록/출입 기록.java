import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int A;
    public static int B;
    public static int count;
    public static int check = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if (map.containsKey(A) && B == 0) {
                map.remove(A);
            }else if(map.containsKey(A) && B == 1){
                check = check+1;
            }else if(!map.containsKey(A) && B == 0){
                check = check+1;
            }else {
                map.put(A,B);
            }
        }
        
        count = map.keySet().size();

        System.out.println(count+check);


    }

}
