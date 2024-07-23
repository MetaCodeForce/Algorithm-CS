class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length; // 배열 크기
        int[] newNums = new int[len];

        //뉴배열에 넣어주기 - 잘못된 for문ㅋ
        /*
        for(int i=0; i< len ; i++){
            if( i<nums1.length ){
                newNums[i]=nums1[i];
                System.out.println("nums1["+i+"] : "+nums1[i]);
            }else{//2
                for(int j=0;j<len-i;j++){
                    newNums[i]=nums2[j];
                    System.out.println("nums2["+i+"] : "+nums2[j]);
                    break;
                }
            }
            //결과 : example2에서 오류
            len : 4
            nums1[0] : 1
            nums1[1] : 2
            nums2[2] : 3
            nums2[3] : 3

            Output
            2.00000
         */
    
        // 1. for문 이용
        int forIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            newNums[forIndex++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            newNums[forIndex++] = nums2[i];
        }
        
        /*
        2. System.arraycopy() 이용
            System.arraycopy(복사대상,  복사시작index위치, 복사저장할대상, 대상배열index위치, 길이)
        */
        //System.arraycopy(nums1, 0, newNums, 0, nums1.length);
        //System.arraycopy(nums2, 0, newNums, nums1.length, nums2.length);
        
        
        /*
        3. Arrays.copyOf() 이용
            Arrays.copyOf(복사대상, newlength) 
        */
        //int[] newNums = Arrays.copyOf(nums1, len);
        //System.arraycopy(nums2, 0, newNums, nums1.length, nums2.length);

        double result ;
        //크기순 정렬 필요
        Arrays.sort(newNums);
        
        if(len%2 !=0 ){     //홀수일때는 인덱스 가운데값 
            int index = len/2; 
            result = newNums[index];            
        }else{              //짝수일때는 가운데두개구하고 /2.0
            int index = len/2; 
            result = (newNums[index-1]+newNums[index])/2.0;
        }
        return result;

    }
       

}