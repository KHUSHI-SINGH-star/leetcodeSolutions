class Solution {
    public int trap(int[] height) {
        // Brust force approach
        // int n = height.length;

        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];

        // // Find maximum height to the left
        // leftMax[0] = height[0];

        // for (int i = 1; i < n; i++) {
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        // }

        // // Find maximum height to the right
        // rightMax[n - 1] = height[n - 1];

        // for (int i = n - 2; i >= 0; i--) {
        //     rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        // }

        // int sum = 0;

        // for (int i = 0; i < n; i++) {
        //     int water = Math.min(leftMax[i], rightMax[i]) - height[i];

        //     sum += water;
        // }

        // return sum;

        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        int sum = 0;
        while (left < right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if (leftmax > rightmax) {
                sum += rightmax - height[right];
                right--;
            } else {
                sum += leftmax - height[left];
                left++;
            }
        }
        return sum;
    }
}
