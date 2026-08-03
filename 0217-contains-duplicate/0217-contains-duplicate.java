class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int k=0;
        for(int num:nums){
            if(map.containsKey(num)){
                return true;
            }else{
                map.put(num,k++);
            }
        }
        return false;
    }
}