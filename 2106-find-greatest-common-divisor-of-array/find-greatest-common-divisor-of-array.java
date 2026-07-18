class Solution {
    public int findGCD(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;

        for (int val: nums) {
            a = Math.min(a,val);
            b = Math.max(b,val);
        }

        return gcd(a,b);
    }

    private int gcd(int a,int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}