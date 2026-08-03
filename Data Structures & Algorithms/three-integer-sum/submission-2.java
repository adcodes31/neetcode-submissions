class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
           if(i>0 &&nums[i]==nums[i-1]) continue;
           int r = i+1;
           int k = nums.length-1;
           while(r<k){
            int sum = nums[i]+nums[r]+nums[k];
            if(sum>0){
                k--;
            }
            else if(sum<0){
                 r++;
            }
            else{
                List<Integer> ar= new ArrayList<>();
                ar.add(nums[i]);
                ar.add(nums[r]);
                ar.add(nums[k]);
                ans.add(ar);
                r++;
                k--;
                while(r<k && nums[r]==nums[r-1])r++;
                while(r<k && nums[k]==nums[k+1]) k--;
           }
           }
        }
        return ans;
    }
}
