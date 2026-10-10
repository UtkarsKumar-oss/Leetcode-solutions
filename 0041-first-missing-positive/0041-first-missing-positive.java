class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] Nums = Arrays.stream(nums).filter(n -> n > 0).toArray();
        Arrays.sort(Nums);
        int target = 1;
        for (int n : Nums) {
            if (n == target) {
                target++;
            } else if (n > target) {
                return target;
            }
        }
        
        return target;        
    }
}