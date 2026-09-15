class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        int n = firstList.length;
        int m = secondList.length;
        ArrayList<int[]> result = new ArrayList<>();
        while (i < n && j < m) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            if (start1 < start2) {
                if (start2 <= end1) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    result.add(new int[] { s, e });
                }
            } else {
                if (end2 >= start1) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    result.add(new int[] { s, e });
                }
            }
            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}