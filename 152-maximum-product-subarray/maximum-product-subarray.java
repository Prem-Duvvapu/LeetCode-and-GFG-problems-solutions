class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i=0;i<n;i++) {
            prefixProduct *= nums[i];
            suffixProduct *= nums[n-1-i];

            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
            prefixProduct = (prefixProduct == 0) ? 1: prefixProduct;
            suffixProduct = (suffixProduct == 0) ? 1: suffixProduct;
        }

        return maxProduct;
    }
}