class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1001]; 
        int total = 0;

        for (int answer : answers) {
            count[answer]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                int otherRabbit = i + 1;
                //
            }

    
    
    }    
}




/*
    Queue<int[]> queue = new LinkedList<>();
        queue.offer(answers);

        int size=queue.size();
        for(int i=0;i<size;i++){
            Integer val = queue.poll();
            queue.offer(val+1);
        }
        boolean allSame = true;
        Integer firstVal = queue.peek(); 
        Integer max = firstVal;
        Integer sameVal;

         for (Integer newVal : queue) {
            if (!newVal.equals(firstVal)) {
                allSame = false;
            }else{
                sameVal = newVal;
            }
            // 최대값 체크
            if (newVal > maxVal) {
                maxVal = newVal;
            }
        }

         if (allSame) {
            return maxVal;
         }else{
            return sameVal+maxVal;
         }

    }
  
 */