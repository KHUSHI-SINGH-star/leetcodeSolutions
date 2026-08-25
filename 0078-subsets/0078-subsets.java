class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        subSequence(nums, 0, new ArrayList<>(), result);
        return result;

    }

    private void subSequence(int[] arr, int index, ArrayList<Integer> list, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[index]);
        subSequence(arr, index + 1, list, result);

        list.remove(list.size() - 1);
        subSequence(arr, index + 1, list, result);
    }
}