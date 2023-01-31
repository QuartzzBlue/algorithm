import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> newTerms = null;
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        newTerms = new HashMap<>();
        for(String term : terms) {
        	String[] split = term.split(" ");
        	newTerms.put(split[0], Integer.parseInt(split[1]));
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date todayDate;
		try {
			todayDate = formatter.parse(today);
	        for(int i = 0; i < privacies.length; i++) {
	        	String item = privacies[i];
	        	String[] privacy = item.split(" ");
	        	Date agreeDate = formatter.parse(privacy[0]);
	            Date expireDate = getExpireDate(agreeDate, privacy[1]);
	            if(todayDate.compareTo(expireDate) >= 0) {
	            	answer.add(i + 1);
	            }
	        }
		} catch (ParseException e) {

			e.printStackTrace();
		}
        return answer.stream()
        		.mapToInt(Integer::intValue)
            	.toArray();
    }
    private static Date getExpireDate(Date agreeDate, String key) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(agreeDate);
        cal.add(Calendar.MONTH, newTerms.get(key));
        return cal.getTime();
	}
}