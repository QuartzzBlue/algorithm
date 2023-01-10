import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }  
        
        return set.size() >= count ? count : set.size();
    }
}