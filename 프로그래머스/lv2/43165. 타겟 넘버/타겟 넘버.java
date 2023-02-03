class Solution {
    public int count = 0;
    public int[] numberList = null;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        numberList = numbers;
        
        sol(0, 0, target);
        
        return count;
    }
    
    public void sol(int idx, int sum, int target) {
        if (numberList.length == idx) {
            if (sum == target) count++;
            return;
        }
        sol(idx+1, sum - numberList[idx], target);
        sol(idx+1, sum + numberList[idx], target);
    }
    
}