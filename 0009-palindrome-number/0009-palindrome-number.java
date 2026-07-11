class Solution {
    public boolean isPalindrome(int x) {
         String str = String.valueOf(x);
        int left=0;
        int r=str.length()-1;
        while(left<r){
            if(str.charAt(left) != str.charAt(r)){
                return false;
            }
            left ++;
            r--;
        }
        return true;      
    }
}