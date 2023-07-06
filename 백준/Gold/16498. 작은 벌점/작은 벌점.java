import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int [] arrA;
    static int [] arrB;
    static int [] arrC;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        arrA = new int [A];
        arrB = new int [B];
        arrC = new int [C];
        
        setPlayerCard(new StringTokenizer(br.readLine()), A, arrA);
        setPlayerCard(new StringTokenizer(br.readLine()), B, arrB);
        setPlayerCard(new StringTokenizer(br.readLine()), C, arrC);
        
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        Arrays.sort(arrC);
        
        for(int i=0; i<arrA.length;i++){
            int selectA = arrA[i];
		    int selectB = nearestNum(selectA,arrB);
			int selectC1 = nearestNum(selectA,arrC);
			int selectC2 = nearestNum(selectB,arrC);
            
            int max1 = compareMaxNumber(selectA, selectB, selectC1);
			int min1 = compareMinNumber(selectA, selectB, selectC1);
			int score1 = max1 - min1;
			
			int max2 = compareMaxNumber(selectA, selectB, selectC2);
			int min2 = compareMinNumber(selectA, selectB, selectC2);
			int score2 = max2 - min2;
			
			answer = Math.min(answer, Math.min(score1, score2));
		}
        
		System.out.println(answer);
	}
    
    static void setPlayerCard(StringTokenizer st, int N, int [] arr){
        for(int i=0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
	
	static int nearestNum(int target, int[] arr) {
		int startIdx = 0;
		int endIdx = arr.length-1;
		int mid = (startIdx + endIdx)/2;
		int nearest = arr[mid];
				
		while(startIdx <= endIdx) {
			mid = (startIdx + endIdx)/2;
			if(arr[mid] == target) return target;
			if(arr[mid] < target) {
				startIdx = mid+1;
			}else if(arr[mid] > target) {
				endIdx = mid-1;
			}
			if(isMoreApproximated(arr[mid],nearest,target)) {
				nearest = arr[mid];
			}
		}
		return nearest;
	}
	
	static boolean isMoreApproximated(int selectedNum, int nearest, int target) {
		if(Math.abs(selectedNum-target) < Math.abs(nearest - target)) return true;
		return false;
	}
    
    static int compareMaxNumber(int A, int B, int C){
        return Math.max(Math.max(A, B), C);
    }
    
    static int compareMinNumber(int A, int B, int C){
        return Math.min(Math.min(A, B), C);
    }
    
}
