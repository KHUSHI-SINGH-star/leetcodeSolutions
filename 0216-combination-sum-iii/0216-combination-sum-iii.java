class Solution {
    private void subset(int k, int n, int sum, int index, List<Integer> list, List<List<Integer>> result) {

        if (list.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if (index > 9 || sum > n) {
            return;
        }

        list.add(index);
        sum += index;
        subset(k, n, sum, index + 1, list, result);

        list.remove(list.size() - 1);
        sum -= index;
        subset(k, n, sum, index + 1, list, result);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        subset(k, n, 0, 1, new ArrayList<>(), result);

        return result;
    }
}