class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        cambination(0,candidates,target,res,ans);
        return ans;
    }
     public void cambination(int idx,int arr[], int target,List<Integer> res,List<List<Integer>> ans){
        if(idx==arr.length){
            if(target==0){
            ans.add(new ArrayList<>(res));
            return;
            }
            return;
        }
        if(arr[idx]<=target){
        res.add(arr[idx]);
        cambination(idx,arr,target-arr[idx],res,ans);
        res.remove(res.size()-1);
        }
        cambination(idx+1,arr,target,res,ans);
    }

}