// Runtime 7 ms Beats 100.00% Analyze Complexity 
// Memory 40.30 MB Beats 41.83% Analyze Complexity


class Solution {
    public int climbStairs(int n) {
        
        int[] rootMemo = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            System.out.println(i);
            // i 까지의 경로 메모이제이션
            if(i == 1){
                rootMemo[i] = 1; // 1
            }else

            if(i == 2){
                rootMemo[i] = 2; // 1+1, 2
            }else

            if(i == 3){
                rootMemo[i] = 3; // 1+1+1, 2+1, 1+2;
            }else

            if(i == 4){
                rootMemo[i] = 5; // 1+1+1+1, 2+1+1, 1+2+1, 1+1+2, 2+2;
            }

            // 정리해보면 피보나치
            else{
                rootMemo[i] = rootMemo[i-1] + rootMemo[i-2];
            }
        }

        return rootMemo[n];
    }
}