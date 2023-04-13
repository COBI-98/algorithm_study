class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Integer.toString(n, k);
        String [] checkNum = num.split("0");
        
        for(String str: checkNum){
            if(str.equals("")){
                continue;
            }
            long number = Long.parseLong(str);
            if(isPrime(number)){
                answer++;
            }  
        }
        
        return answer;
    }
    
    public static boolean isPrime(long num){
        if(num == 1){
            return false;
        }else if (num == 2){
            return true;
        }
        
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}