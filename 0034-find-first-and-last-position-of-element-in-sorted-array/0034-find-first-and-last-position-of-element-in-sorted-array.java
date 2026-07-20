class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (idx == -1) {
            return new int[] { -1, -1 };
        }
        left = idx;
        right = idx;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }

        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }

        return new int[] { left, right };

    }
}