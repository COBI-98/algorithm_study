import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c==')' && stack.peek()=='('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        if(stack.size() != 0){
            answer = false;
        }
        return answer;
    }
}