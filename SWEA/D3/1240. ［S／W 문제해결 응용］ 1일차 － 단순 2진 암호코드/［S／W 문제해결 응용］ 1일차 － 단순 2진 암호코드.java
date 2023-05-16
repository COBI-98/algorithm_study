import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

class Solution{
    static int N;
    static int M;
    static String [] codeList = {"0001101","0011001","0010011","0111101","0100011",
                                   "0110001","0101111","0111011","0110111","0001011"};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T;
		T= Integer.parseInt(br.readLine());
		/**
         * 가로 5
         * 세로 56 7*8
         */
        StringTokenizer st;
        String [] pwCode ;
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
			boolean isFindOne = false;
            int x = 0;
            int y = 0;
            pwCode = new String[9];
            
            for(int i=0; i<N; i++){
            	String str = br.readLine();
                for(int j=0; j<M; j++){
                    if(!isFindOne){
                        int oneCheck = str.charAt(j) - '0';
                    if(oneCheck == 1){
                        int zeroCheck = j-3;
                        if(zeroCheck < 0){
                            zeroCheck = 0;
                        }
                    	for(int k=zeroCheck;k<j;k++){
                        	String code = str.substring(k,k+7);
                            for(int z = 0; z<10; z++){
                            	if(code.equals(codeList[z])){
                                	x = i;
                                    y = k;
                                }
                            }
                        }
                        for(int start = 1; start<=8 ; start++){
                            pwCode[start] = str.substring((y+((start-1) * 7)),(y+((start) * 7)));
                        }
                        
                        isFindOne = true;
                        break;
                    }
                    }
                	
                }
                
            }
            
            int a = 0;
    		int b = 0;

            for(int i=1;i<=8;i++){
                    for(int j=0; j<10;j++){
 				       if(pwCode[i].equals(codeList[j])){
      						  if(i%2 == 1){
     							   a += j;
     						   }else{
    							    b += j;
   				     }
    			    }
     			   }
	     	   }

            if(((a*3)+b) % 10 == 0){
                sb.append("#"+test_case+" "+(a+b)+"\n");
            }else{
          	  sb.append("#"+test_case+" "+0+"\n");
            }	

		}
        System.out.println(sb);
	}
}