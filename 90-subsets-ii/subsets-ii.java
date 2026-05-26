class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        subset(0,nums,res,ans);
        return ans;
    }
    public void subset(int idx,int arr[],List<Integer> res,List<List<Integer>> ans){
        ans.add(new ArrayList<>(res));
        for(int i=idx;i<arr.length;i++){
            if(i!=idx&&arr[i]==arr[i-1])continue;
            res.add(arr[i]);
            subset(i+1,arr,res,ans);
            res.remove(res.size()-1);

        }
    }
}