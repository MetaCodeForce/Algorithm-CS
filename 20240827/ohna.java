class Solution {
    public int myAtoi(String s) {
        boolean negTf = false; //음수여부 (-)
        long result =0;
        // 1.
        s = s.trim();
        // 2.
        if(s.charAt(0) == '-') negTf = true; 
        
        //3.
        int idx =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i) ;
            if(c == '-' || c =='+' ){
                break;
            }
            if(c>=0 || c<=9){
                idx = i;
            }else{
                break;
            }
        }
        s = s.substring(0,idx+1);
        System.out.println(s);
        
        result = Long.parseLong(s); ///<<<<런타임 오류 java.lang.NumberFormatException:
        /////////// ex "1337c0d3" 
        //일단 커밋 ㄱ졸려

        if(negTf) result *=-1L;

        if(result <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else if(result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else{
            return  (int)result;
        }

        
    }
}