class Solution {
  public String solution(int n) {
      String answer = "";
      StringBuffer ans_rev = new StringBuffer();
      int rest = -1;
      
      while(n>0){
          rest = n%3;
          n = n/3;
          if(rest == 0){
              ans_rev.append(4);
              n = n-1;
          }else{
              ans_rev.append(rest);
          }
      }

      answer = ans_rev.reverse().toString();

      return answer;
  }
}