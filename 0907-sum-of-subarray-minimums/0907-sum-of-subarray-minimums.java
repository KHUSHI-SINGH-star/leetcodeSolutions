class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                next[i] = n;
            } else {
                next[i] = stack.peek();
            }

            stack.push(i);
        }

        // Calculate answer
        long sum = 0;
        long MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {

            long left = i - prev[i];
            long right = next[i] - i;

            long contribution = arr[i] * left * right;

            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }
}
