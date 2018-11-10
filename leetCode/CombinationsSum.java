/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

*/


class Solution {

    public void combinationsHelper(int[] candidates, int j, List<List<Integer>> res, List<Integer> curr, int target) {
        if(target == 0){
           ArrayList<Integer> temp = new ArrayList<>(curr);
            res.add(temp);
            return;
        }
        
        for(int i = j; i < candidates.length; i++){
            if(candidates[i] > target){
                return;
            }
            
            curr.add(candidates[i]);
            combinationsHelper(candidates, i, res, curr, target-candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res =  new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        combinationsHelper(candidates, 0,res,curr, target);
        return res;
    }
}
