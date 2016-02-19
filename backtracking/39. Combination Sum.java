public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List <Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        int sum = 0;
        helper(candidates, target, result, temp, 0, sum);
        return result;

    }

    public void helper(int[] candidates, int target, List<List <Integer>> result, List<Integer> temp, int pos, int sum) {


        for (int i = pos; i < candidates.length; i++) {
            if (sum == target) {
                result.add(new ArrayList(temp));
                sum = 0;
                return;
            }


            if (sum < target) {
                temp.add(candidates[i]);
                sum = sum + candidates[i];
                helper(candidates, target, result, temp, i , sum);
                sum = sum - temp.get(temp.size() - 1);
                temp.remove(temp.size() - 1);

            }
        }
    }
}