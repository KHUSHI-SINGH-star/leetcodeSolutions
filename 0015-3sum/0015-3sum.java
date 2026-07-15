class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //     List<List<Integer>> list = new ArrayList<>();
        //     Set<List<Integer>> set = new HashSet<>(); 
        // for(int i=0;i<nums.length;i++){
        //     int target=0-nums[i];
        //     HashMap<Integer,Integer> map=new HashMap<>();
        //     for(int j=i+1;j<nums.length;j++){
        //         int needed=target-nums[j];
        //         if(map.containsKey(needed)){
        //             List<Integer> temp = Arrays.asList(nums[i], nums[j], needed);
        //             Collections.sort(temp);
        //          set.add(temp);
        //         }
        //         map.put(nums[j],j);

        //     }
        // }
        
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>(); 
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                    Collections.sort(temp);
                    set.add(temp);
                }
                if (currentSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        list.addAll(set);
        return list;
     }
}