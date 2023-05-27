import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) { 
            int left = sc.nextInt(); 
            for (int j = 1; j <= n; j++) {
                if (left == 0 && arr[j] == 0) { 
                    arr[j] = i; 
                    break;
                } else if (arr[j] == 0) { 
                    left--;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}