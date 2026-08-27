class Solution {
    class Pair {
        int value;
        int frequency;

        Pair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> dq = new PriorityQueue<>(
                (a, b) -> a.frequency - b.frequency);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            dq.add(new Pair(entry.getKey(), entry.getValue()));

            if (dq.size() > k) {
                dq.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = dq.poll().value;
        }
        return ans;
    }
}