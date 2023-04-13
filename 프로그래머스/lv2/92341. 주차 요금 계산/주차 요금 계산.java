
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        Map<String, List<Integer>> recordMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        
        for(String record : records) {
            String time = record.split(" ")[0];
            int timeAmount = 60 * Integer.parseInt(time.split(":")[0]);
            timeAmount += Integer.parseInt(time.split(":")[1]);
            
            String car = record.split(" ")[1];
            if(recordMap.containsKey(car)) {
                recordMap.get(car).add(timeAmount);
            }
            else {
                List<Integer> timeList = new ArrayList<>();
                timeList.add(timeAmount);
                recordMap.put(car, timeList);
            }
        }
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];
        
        for(String key : recordMap.keySet()) {
            List<Integer> arr = recordMap.get(key);
            
            int timeSum = 0;
            if(arr.size() % 2 != 0) {
                arr.add(23*60 + 59);
            }
            for(int i=0; i<arr.size(); i+=2) {
                int endTime = arr.get(i+1);
                int startTime = arr.get(i);
                timeSum += endTime - startTime;
            }
            
            timeSum -= basicTime;
            int fee = basicFee;
            
            while(timeSum > 0) {
                timeSum -= addTime;
                fee += addFee;
            }
            answerMap.put(key, fee);
        }
        
        List<String> keyList = new ArrayList<>(answerMap.keySet());
        Collections.sort(keyList); 
        
        answer = new int[keyList.size()];
        for(int i=0; i<keyList.size(); i++) { 
            answer[i] = answerMap.get(keyList.get(i));
        }
        
        return answer;
    }
}