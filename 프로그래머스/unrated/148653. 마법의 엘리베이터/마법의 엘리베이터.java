class Solution {
    static int minCnt = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        elevator(storey, 0);
        return minCnt;
    }
    
    private static void elevator (int storey, int cnt) {
		if(storey < 10) {
            if(storey > 5) {
                cnt += (10-storey) +1;
            } else {
                cnt += storey;
            }
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		int num = storey % 10;

		if(num == 0) {
			elevator(storey/10, cnt);
		} else {
			elevator(storey/10, cnt+num);
			elevator(storey/10 +1, cnt+(10-num));
		}

	}
}