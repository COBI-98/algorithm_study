import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 1, temp = 1;
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   
        int k = Integer.parseInt(st.nextToken());   
        int c = Integer.parseInt(st.nextToken());   
        int[] num = new int[N];
        int[] sushi = new int[d + 1];

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        sushi[c]++;
        for(int i = 0; i < k; i++){
            if(sushi[num[i]]++ == 0)
                answer++;
        }
        temp=answer;

        for (int i = 1; i < N; i++) {
            if(sushi[num[i-1]] > 0){
                sushi[num[i-1]]--;
                if(sushi[num[i-1]] == 0)
                    answer--;
            }  
            if(sushi[num[(i+k-1) % N]]++ == 0){
                answer++;
            }
            temp = Math.max(temp, answer);
        }
        System.out.println(temp);
    }
}