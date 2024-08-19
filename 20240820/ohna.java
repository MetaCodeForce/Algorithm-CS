class Solution {
    public int reverse(int x) {

        // 1.
        /* 
        String s = Integer.toString(x);
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int result;
        try{
            if(x > 0){
                for(int i =len-1; i >=0; i--){
                    sb.append(s.charAt(i));
                }
            }else{
                sb.append(s.charAt(0));
                for(int i =len-1; i >=1; i--){
                    sb.append(s.charAt(i));
                }
            }
            result =  Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            result = 0;
        }
        return result;
        */
        
        // 2.
        int result =0;;
        try{
            String[] sArr = Integer.toString(Math.abs(x)).split("");
            StringBuilder sb = new StringBuilder();
            if(x<0) {
                sb.append("-");
            }

            for(int i =sArr.length-1; i >=0; i--){
                sb.append(sArr[i]);
            }
            result =  Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            result = 0;
        }
        return result;


    }
}