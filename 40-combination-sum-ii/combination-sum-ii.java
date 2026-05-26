class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        cambination(0, candidates, target, res, ans);

        return ans;
    }

    public void cambination(int idx, int arr[], int target, List<Integer> res, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
              break;
            res.add(arr[i]);
            cambination(i+ 1, arr, target - arr[i], res, ans);
            res.remove(res.size() - 1);
        }
    }

}
