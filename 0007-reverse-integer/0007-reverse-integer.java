class Solution {
    public int reverse(int x) {
        // int rev = 0;
        // while (x != 0) {
        //     int digit = x % 10;
        //     x = x / 10;

        //     if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10)
        //         return 0;

        //     rev = rev * 10 + digit;
        // }

        // return rev;
        boolean negative = x < 0;
        String s = String.valueOf(Math.abs((long) x));
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        long rev = Long.parseLong(new String(arr));

        if (negative) {
            rev = -rev;
        }

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rev;
    }
}