import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        //1. 문자제거하기
        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            // 현재 스택이 비어있지않고 peek 스택의 최상위 값이 c와 같다면 pop  
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        answer = stack.size() == 0 ? 1 : 0;
        
        return answer;
    }
}