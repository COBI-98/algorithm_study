import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if (str.equals("end")){
                break;
            }

            sb.append("<"+str+"> " + (isAcceptPassword(str)? "is acceptable." : "is not acceptable."));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isAcceptPassword(String password){
        int check = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (check >0){
                break;
            }

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                check++;
            }
        }

        if (check == 0){
            return false;
        }

        int gather = 0;
        int consonant = 0;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                if (consonant > 0){
                    consonant = 0;
                }
                gather++;
            }else{
                if (gather > 0){
                    gather = 0;
                }
                consonant++;
            }

            if (consonant == 3 || gather == 3){
                return false;
            }
        }

        if (password.length() == 1){
            return true;
        }

        for (int i = 1; i < password.length(); i++) {
            char ch = password.charAt(i-1);
            char cur_ch = password.charAt(i);
            if (ch == cur_ch){
                if (cur_ch != 'e' && cur_ch != 'o'){
                    return false;
                }
            }
        }

        return true;
    }
}
