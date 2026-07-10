class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num = nums1.length + nums2.length;
        int[] array = new int[num];

        for (int i = 0; i < nums1.length; i++) {
            array[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            array[nums1.length + i] = nums2[i];
        }
        Arrays.sort(array);
        if (num % 2 == 0) {
            return (array[num / 2] + array[num / 2 - 1]) / 2.0;
        } else {
            return array[num / 2];
        }
    }
}