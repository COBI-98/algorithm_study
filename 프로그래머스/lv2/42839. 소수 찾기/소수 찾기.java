import java.util.*;
import java.io.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>(); 
    static int m;
    static char[] arr; 
    static boolean[] visited; 
        
    public int solution(String numbers) {
        int answer = 0;
        m = numbers.length();
        arr = new char[m];
        visited = new boolean[m];
        
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i); 
        }
                
        recursion("",0); 
        
        answer = set.size();
        return answer;
    }
    
    public static void recursion(String str, int idx){
        int num;
        
        if(str!=""){
            num = Integer.parseInt(str);
            if(isPrime(num)) {
                set.add(num); // 소수판별
            }
        }
        
        if(idx==arr.length){
           return;  
        } 
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) {
                continue; 
            }
            visited[i] = true; 
            recursion(str+arr[i], idx+1);
            visited[i] = false; 
        }
    }
    
    public static boolean isPrime(int num){
        if(num==0||num==1) 
            return false;
        
        for(int i=2; i*i<=num;i++){
            if(num%i==0) 
                return false;
        }
        return true;
    }
}