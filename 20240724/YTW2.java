public class YTW2 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        new YTW2().test20240724(nums1, nums2);
    }

    public int test20240724(int[] nums1, int[] nums2){
        int numsLength = nums1.length + nums2.length; 
        int[] nums = new int[numsLength];

        // nums합치기
        for (int i = 0; i < nums.length; i++) {
            if (i < nums1.length) {
                nums[i] = nums1[i];
            } else {
                nums[i] = nums2[i - nums1.length];
            }
        }

        EGinTree root_EginTree = new EGinTree();
        EGinTree lastNode = null;
        EGinTree currNode = null;

        int leftCount = 0;
        int rightCount = 0;
        int middleNum = 0;

        // 이진 탐색
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (i == 0) {
                root_EginTree.setValue(value);
                lastNode = root_EginTree;
            } else {
                currNode = new EGinTree(value);
                while (lastNode.left_EginTree != currNode && lastNode.right_EginTree != currNode) {
                    // 좌노드 삽입
                    if (lastNode.value > currNode.value) {
                        if (lastNode.left_EginTree == null) {
                            lastNode.left_EginTree = currNode;
                            leftCount++;
                        } else {
                            lastNode = lastNode.left_EginTree;
                            continue;
                        }
                    // 우노드 삽입
                    } else if (lastNode.value < currNode.value) {
                        if (lastNode.right_EginTree == null) {
                            lastNode.right_EginTree = currNode;
                            rightCount++;
                        } else {
                            lastNode = lastNode.right_EginTree;
                            continue;
                        }
                    }
                }

            }
            // 중간값 찾기
            if(leftCount == 0 && rightCount == 0) middleNum = value;
            if(leftCount == rightCount && leftCount > 0 && rightCount > 0) middleNum = value;
            
            System.out.println("\nIn " + value);
            System.out.println("In lastNode : " + lastNode);
            System.out.println("In lastNode.value : " + lastNode.value);
            System.out.println("lastNode.left_EginTree : " + lastNode.left_EginTree);
            System.out.println("lastNode.right_EginTree : " + lastNode.right_EginTree);
            System.out.println("currNode : " + currNode);
            System.out.println("leftCount : " + leftCount);
            System.out.println("rightCount : " + rightCount);
            System.out.println("middleNum : " + middleNum);
        }
        return middleNum;
    }

    public class EGinTree{
        private int value;
        private EGinTree left_EginTree;
        private EGinTree right_EginTree;

        // constructor
        public EGinTree(){
            
        }
        public EGinTree(int value){
            this.value = value;
        }

        // Setter
        public void setValue(int value){
            this.value = value;
        }
        public void setLeftEGinTree(EGinTree eGinTree){
            this.left_EginTree = eGinTree;
        }
        public void setRightEGinTree(EGinTree eGinTree){
            this.right_EginTree = eGinTree;
        }

        // toString
        // public String toString(){
        //     return String.valueOf(this.value)+"\n";
        // }
    }
} 