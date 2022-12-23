import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        boolean []check=new boolean[30];
        for(int i=0;i<28;i++){
            int num=scanner.nextInt()-1;
            check[num]=true;
        }
        for(int i=0;i<30;i++){
            if(!check[i]){
                System.out.println(i+1);
            }
        }
    }
}