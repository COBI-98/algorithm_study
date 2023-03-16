import java.util.*;
import java.io.*;

class Solution {
    public static int[] students = new int[3];
    public static int m;
    public static int[] student1 = {1,2,3,4,5};
    public static int[] student2 = {2,1,2,3,2,4,2,5};
    public static int[] student3 = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        m = answers.length;
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        student1Check(answers);
        student2Check(answers);
        student3Check(answers);
        
        int max = Math.max(students[0],Math.max(students[1],students[2])); // max값 구하기
        
        ArrayList<Integer> checkAnswer = new ArrayList<Integer>();
        if(max==students[0]) checkAnswer.add(1);
        if(max==students[1]) checkAnswer.add(2);
        if(max==students[2]) checkAnswer.add(3);
        
        int [] answer = new int[checkAnswer.size()];
        for(int i=0;i<checkAnswer.size();i++){
            answer[i] = checkAnswer.get(i);
        }
        
        return answer;
    }
    
    public static void student1Check(int [] answers){
        for(int i =0; i<m;i++){
            int j = i%5;
            
            if(student1[j] == answers[i] ){
                students[0]++;
            }
        }
    }
    
    public static void student2Check(int [] answers){
        for(int i =0; i<m;i++){
            int j = i%8;
            
            if(student2[j] == answers[i]){
                students[1]++;
            }
        }
    }
    
    public static void student3Check(int [] answers){
        for(int i =0; i<m;i++){
            int j = i%10;
            
            if(student3[j] == answers[i] ){
                students[2]++;
            }
        }
    }
}