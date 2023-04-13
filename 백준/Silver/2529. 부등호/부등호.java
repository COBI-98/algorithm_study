import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static String [] sign ;
    static int [] numbers = {0,1,2,3,4,5,6,7,8,9};
    static boolean [] used ;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        sign = new String[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken();
        }

        for (int i = 0; i < numbers.length; i++) {
            used = new boolean[10];
            if (!used[i]){
                used[i] = true;
                backT(0,i,i+"");
                used[i] = false;
            }
        }

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    public static void backT(int depth, int curX, String word){

        if (word.length() == k+1){
            list.add(word);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (sign[depth].equals("<")){
                if (curX < i && !used[i]){
                    used[i] = true;
                    backT(depth+1,i,word+i);
                    used[i] = false;
                }
            }else{
                if (curX > i && !used[i]){
                    used[i] = true;
                    backT(depth+1,i,word+i);
                    used[i] = false;
                }
            }
        }
    }
}
