class Solution {

    //40.37MB
    //Beats42.12%
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2; 

        for(int i=3; i<=n; i++){
            memo[i]= memo[i-1]+memo[i-2];
        }

        return memo[n];
    
    }

    //초안 2차원 배열 이용했음
    //40.51MB
    //Beats 20.52%
    public int climbStairs_1(int n) {
        if ( n== 1) return 1;

        int [][] memo = new int [n+1][2];

        // 1층
        memo[1][0] = 1; //1계단 1층
        memo[1][1] = 0; //1계단 2층 -불가
        //2층
        memo[2][0] = 1;
        memo[2][1] =1 ;
        
        for(int i=3;i<=n;i++){
            memo[i][0]=memo[i-1][0]+memo[i-1][1];
            memo[i][1]=memo[i-2][0]+memo[i-2][1];
        }

        return memo[n][0]+memo[n][1];
    }
}
    

