class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int sec = pq.poll();
            int res = first - sec;

            pq.add(res);
        }
        return pq.peek();
    }
}