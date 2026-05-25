class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subSet=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        creatSubSet(nums,0,subSet,ans);
        return ans;
    }
    public void creatSubSet(int nums[],int idx,List<Integer> subSet,List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(nums[idx]);
        creatSubSet(nums,idx+1,subSet,ans);
        subSet.remove(subSet.size()-1);
        creatSubSet(nums,idx+1,subSet,ans);
    }
}