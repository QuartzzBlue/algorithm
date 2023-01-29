import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < moves.length; i++) {
            int x = moves[i]-1;
            for(int[] low : board){
                if(low[x] == 0) {
                    continue;
                } else {
                  if(stack.size() != 0 && stack.peek() == low[x]) {
                      stack.pop();
                      answer += 2;
                  } else {
                      stack.push(low[x]);
                  }
                  low[x] = 0;
                  break;
                }
            }
        }

        return answer;
    }
}