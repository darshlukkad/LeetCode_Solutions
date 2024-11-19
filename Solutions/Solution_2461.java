class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n=nums.length;
        long sum=0;
        long ans=0;
        for(int i=0;i<k;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum=sum+nums[i];
        }
        for(int i=0;i<n-k+1;i++) {
            if(sum>ans && map.size()==k)
                ans=sum;
            if(i+k<n) {
                int temp=map.get(nums[i]);
                if(temp==1)
                    map.remove(nums[i]);
                else
                    map.put(nums[i],temp-1);
                
                map.put(nums[i+k],map.getOrDefault(nums[i+k],0)+1);
                sum=sum-nums[i]+nums[i+k];
            }
        }
        return ans;
    }
}