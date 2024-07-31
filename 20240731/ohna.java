class Solution {
    public String longestPalindrome(String s) {
        String result ="";
        int len = s.length();
        if(s == null || len<2){
            return s;
        }
        
        //홀짝구분???
        if(len%2!=0){//홀
            for(int i=1;i<len;i++){
                findMethod(s,i-1,i+1);
            }
        }else{  //짝??

        }

        //찾기...
        return result;
           
    }


    public String findMethod(String s,int left, int right){
        while(left>=0){
            if(s.charAt(left) == s.charAt(right) ){
                s.substring(left, right);
            }
            break;
        }
        return s;
    }

}