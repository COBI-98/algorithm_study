import java.util.Stack;

class Solution {
    public static int answer = 0;
    public static int pick = 0;
    public int solution(int[] nums) {
        pick = nums.length / 2;
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i<nums.length; i++){
            if(!stack.contains(nums[i])){
                stack.push(nums[i]);
            }
            
        }
        
        if(stack.size() >= pick){
            answer = pick; 
        }else{
            answer = stack.size();
        }
        // HashMap<Integer,Integer> hashList = new HashMap<>();
        
        return answer;
    }
}