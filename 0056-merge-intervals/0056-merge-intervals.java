class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals by starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] result = new int[intervals.length][2];
        int ind = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                result[ind++] = new int[] { start, end };
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result[ind++] = new int[] { start, end };
        return Arrays.copyOf(result, ind);
    }
}