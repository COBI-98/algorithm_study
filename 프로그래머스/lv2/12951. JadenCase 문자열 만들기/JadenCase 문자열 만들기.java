class Solution {
    public String solution(String s) {
        String answer = "";
        String p = s.toLowerCase();
        
        String [] result = p.split(" ");   
        
        String [] array = new String[result.length];
        
        for(int i = 0; i<result.length; i++){
            if(result[i].equals("")){
                array[i] = "";
            } else{
                 String check =result[i].substring(0,1).toUpperCase() + 
                    result[i].substring(1);

                array[i] = check;   
            }
            
        }
        
        answer = String.join(" ", array);
        
        if(s.charAt(s.length()-1) == ' '){
            answer = answer + " ";
        } 
        
        return answer;
    }
}