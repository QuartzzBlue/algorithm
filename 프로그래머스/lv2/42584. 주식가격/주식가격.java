import java.util.ArrayList;
class Solution {
    public int[] solution(int[] prices) {
//         int pricesLen = prices.length;
//         int[] answer = new int[pricesLen];
        
// 		boolean flag = false;
		
// 		for(int i = 0; i < pricesLen-1; i++){
// 	        for(int j = i+1; j < pricesLen; j++){
// 	            boolean equal = prices[j] < prices[i]; 
// 	            if(equal) {
// 	            	answer[i] = j - i;
// 	            	flag = true;
// 	            }
// 	            if(j == pricesLen-1 && flag == false) {
// 	            	answer[i] = j - i;
// 	            	flag = true;
// 	            }
// 	            if(flag == true) {
// 	            	flag = false;
// 	            	break;
// 	            }
	            
// 	        }
// 	    }
//         answer[pricesLen-1] = 0;
//         return answer;
        ArrayList<Integer> resp = new ArrayList<>();
		for(int i = 0; i < prices.length; i++) {
			int sec = 0;
			a:for(int j = i+1; j < prices.length; j++) {
				sec++;
				if(prices[j] < prices[i] || j == prices.length-1) {
					break a;
				}
			}
			resp.add(sec);
		}
		return resp.stream().mapToInt(i->i).toArray();
    }
}