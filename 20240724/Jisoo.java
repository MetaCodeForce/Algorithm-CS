class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < nums1.length; i++) {
            while (idx < nums2.length && nums2[idx] < nums1[i]) {
                list.add(nums2[idx]);
                idx++;
            }
            list.add(nums1[i]);
        }

        for (int i = idx; i < nums2.length; i++) {
            list.add(nums2[i]);
        }

        idx = list.size() / 2;

        if (list.size() % 2 == 1) {
            return list.get(idx);
        }

        return (list.get(idx - 1) + list.get(idx)) / (double) 2;
    }
}