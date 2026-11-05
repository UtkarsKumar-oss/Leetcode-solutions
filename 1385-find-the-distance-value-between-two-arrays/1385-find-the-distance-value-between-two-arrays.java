class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int a : arr1) {
            boolean found = false;
            for (int b : arr2) {
                if (Math.abs(a - b) <= d) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res++;
            }
        }
        return res;
    }
}