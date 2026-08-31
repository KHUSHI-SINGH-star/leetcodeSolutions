class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int Leftsum = 0;
        int Rightsum = 0;

        for (int i = 0; i < k; i++) {
            Leftsum += cardPoints[i];
        }

        int maxsum = Leftsum;
        int j = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            Leftsum -= cardPoints[i];
            Rightsum += cardPoints[j];
           maxsum = Math.max(maxsum, Leftsum + Rightsum);
            j--;
        }

        return maxsum;

    }
}