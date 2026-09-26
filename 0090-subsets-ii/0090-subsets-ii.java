class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        list.add(nums[index]);
        helper(nums, index + 1, list);
        list.remove(list.size() - 1);
        int next = index + 1;

        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }

        helper(nums, next, list);
    }
}