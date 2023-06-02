
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize the list of subsets with an empty subset
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        // Recursively generate all subsets
        generateSubsets(nums, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void generateSubsets(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        // Base case: we have generated all subsets
        if (index == nums.length) {
            return;
        }
        
        // Generate all subsets that include the current element
        curr.add(nums[index]);
        result.add(new ArrayList<>(curr));
        generateSubsets(nums, index + 1, curr, result);
        
        // Generate all subsets that don't include the current element
        curr.remove(curr.size() - 1);
        generateSubsets(nums, index + 1, curr, result);
    }
}