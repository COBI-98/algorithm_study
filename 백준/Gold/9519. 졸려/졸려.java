import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	static int X; 
	static char[] word;
	static int len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		word = br.readLine().toCharArray();   

		len = word.length;
		getOriginalWord();
	}

	private static void getOriginalWord() {
		ArrayList<char[]> orderList = new ArrayList<>();
		orderList.add(word);
		mixWord(orderList);

		StringBuilder sb = new StringBuilder();
		int idx = X % orderList.size();
		char[] originWord = orderList.get(idx);
		for(char c : originWord) {
			sb.append(c);
		}
		System.out.print(sb);
	}

	private static void mixWord(ArrayList<char[]> orderList) {
		char[] mix = new char[len];
		copyArray(mix, word);	
		Stack<Character> back = new Stack<>();

		int half = len / 2;
		int idx;
		while(true) {
			char[] tmp = new char[len];
			idx = 0;
			for(int i=0, b=0; i<len; i++) {
				if(b < half && i%2==1) {
					back.add(mix[i]);
					b++;
				}else {
					tmp[idx++] = mix[i];
				}				
			}

			while(!back.isEmpty()) {
				tmp[idx++] = back.pop();
			}

			if(sameWord(tmp)) break;

			orderList.add(tmp);			
			copyArray(mix, tmp);			
		}

	}

	private static boolean sameWord(char[] tmp) {
		for(int i=0; i<len; i++) {
			if(tmp[i] != word[i]) return false;
		}
		return true;
	}

	private static void copyArray(char[] temp, char[] origin) {
		for(int i=0; i<len; i++) {
			temp[i] = origin[i];
		}		
	}

}