class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if(isSorted(s)) return 0;
        if (n == 2 ) return -1;
        char min = 'z';
        char max = 'a';
        for(char ch : s.toCharArray()){
            min = (char)Math.min(min,ch);
            max = (char)Math.max(max,ch);
        }
        if(min== s.charAt(0) || max== s.charAt(n-1)) return 1;
        for(int i=1;i<n-1;i++) {
            if(s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }
        return 3;
    }
    boolean isSorted(String s){
        for(int i = 0; i<s.length()-1; i++){
            if(s.charAt(i) > s.charAt(i+1)) return false;
        }
        return true;
    }
}