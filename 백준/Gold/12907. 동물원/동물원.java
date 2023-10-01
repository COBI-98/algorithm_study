import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    
	static int N;
	static int animal[];
	static int animal_cnt[];
	static boolean flag=false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		N = Integer.parseInt(br.readLine());
        
		animal = new int[N];
		animal_cnt = new int[41];
		st = new StringTokenizer(br.readLine());
        
		for (int i = 0; i < N; i++) {
			animal[i]=Integer.parseInt(st.nextToken());
			animal_cnt[animal[i]]++;
		}
		int sum = 0;
		int result = 1;
		boolean findOne = false;
        
		for(int i = 0 ; i < N ; i++) {
			if(animal_cnt[i] == 2) {
				if(!findOne) result *= 2;
				else break;
			}else if(animal_cnt[i] == 1) {
				findOne = true;
			}else {
				break;
			}
			sum+=animal_cnt[i];
		}
        
		if(findOne) result *= 2;
		if(sum != N) result = 0;
        
		System.out.println(result);
	}
	
}