import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1;i++){
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            if(ch1 >= 97 && ch1 <=122 && ch2 >= 97 && ch2<=122){
                list1.add(str1.substring(i,i+2));
            }
        }
        
        for(int i=0; i<str2.length()-1;i++){
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            if(ch1 >= 97 && ch1 <=122 && ch2 >= 97 && ch2<=122){
                list2.add(str2.substring(i,i+2));
            }
        }
        
        Collections.sort(list1);
		Collections.sort(list2);
		// aa aa : aa aa aa
		for(String s : list1) {
			if(list2.remove(s)) { 
				intersection.add(s);
			}
			union.add(s);
		}
		
		for(String s : list2) {
			union.add(s);
		}
        
        double jakard = 0;
      
        if(union.size() == 0) {
              jakard = 1;
        } else {
              jakard = (double)intersection.size() / (double)union.size();
        }

        return (int)(jakard * 65536);
    }
}