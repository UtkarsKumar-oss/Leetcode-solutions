class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int w = n - k; 
        int total = 0;
        for (int x : arr) total += x;
        if (w == 0) return total; 
        int i = 0, j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < n) {
            sum += arr[j];
            if (j - i + 1 == w) {
                min = Math.min(min, sum);
                sum -= arr[i]; 
                i++;
            }
            j++;
        }
        return total - min;
    }
}