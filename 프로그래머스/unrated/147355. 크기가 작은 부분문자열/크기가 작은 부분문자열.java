class Solution {
    public int solution(String t, String p) {
        int answer = 0;
		int strLen = p.length();
		double pNum = Double.parseDouble(p);
		
		if(strLen > t.length()) {
			return pNum >= Integer.parseInt(t) ? 1 : 0;
		}
		for(int i = 0; i < t.length()-strLen+1; i++) {
			double tNum = Double.parseDouble(t.substring(i, i+strLen));
			System.out.println(tNum);
			if(pNum >= tNum) answer++;
		}
		
		return answer;
    }
}