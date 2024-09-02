package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _009 {
    class Solution {
        public boolean isPalindrome(int x) {
            int y = Math.abs(x);
            int reverse = 0;
            boolean result = false;

            while(y!=0){
                int digit = y%10;
                reverse = reverse * 10 + digit;
                y/=10;
            }

            if(x==reverse){
                result = true;
            }

            return result;
        }
    }
}
