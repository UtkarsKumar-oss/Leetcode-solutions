class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] cnt = new int[30];
        for (int x : nums) {
            for (int b = 0; b < 30; b++) {
                cnt[b] += (x >> b) & 1;
            }
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            long cur = 0;
            for (int b = 0; b < 30; b++) {
                if (cnt[b] > 0) {
                    cnt[b]--;
                    cur |= 1L << b;
                }
            }
            cur %= MOD;
            ans = (ans + cur * cur) % MOD;
        }
        return (int) ans;
    }
}