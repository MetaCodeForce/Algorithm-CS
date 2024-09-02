class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if( x < 0 || x %10 == 0 ){
            return false;
        }
        // 1) 
    //   int len = Integer.toString(x).length() -1 ;
    //     int rev =0;
    //     int origin = x;

    //     while(len>=0){
    //         rev += (int)((origin % 10) * Math.pow(10,len)); 
    //         origin = origin/10;
    //         len--;
    //     }

        // 2)
        int rev =0;
        int origin = x;
        while(origin > 0 ){
            rev = rev*10 + origin%10;
            origin/=10;
        }

        if(x == rev){
            return true;
        }else {
            return false;
        }
    }
}