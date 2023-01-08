import java.util.Arrays;

class Solution {
    static final int DIV = 1000000007;
    // 오른쪽, 아래
    int[] dirX = {1, 0};
    int[] dirY = {0, 1};
    
    int[][] cache;
    boolean[][] puddles;
    int schoolX;
    int schoolY;
    
    private void init(int x, int y, int[][] puddlesPos) {
        schoolX = x;
        schoolY = y;
        cache = new int[y+1][x+1];
        for(int[] tmp : cache){
            Arrays.fill(tmp, 0);
        }
        cache[1][1] = 1;
        puddles = new boolean[y+1][x+1];
        for(int[] tmp : puddlesPos){
            int px = tmp[0];
            int py = tmp[1];
            puddles[py][px] = true;
        }
    }
    
    private void calc() {
        for(int i = 1; i <= schoolY; i++) {
            for(int j = 1; j <= schoolX; j++) {
                if(puddles[i][j] == true) continue;
                else{
                    if(i == 1) cache[i][j] += cache[i][j - 1];
                    else cache[i][j] = (cache[i-1][j] + cache[i][j-1]) % DIV;

                }
            }
        }
    }
    
    public int solution(int m, int n, int[][] puddles) {
        init(m, n, puddles);
        calc();
        return cache[schoolY][schoolX];
    }
}