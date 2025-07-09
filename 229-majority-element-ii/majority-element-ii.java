class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int majority1 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int majority2 = Integer.MAX_VALUE;
        int cnt2 = 0;

        for (int val: nums) {
            if (val==majority1) {
                cnt1++;
            } else if (val==majority2) {
                cnt2++;
            } else if (cnt1==0) {
                majority1 = val;
                cnt1++;
            } else if (cnt2==0) {
                majority2 = val;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        int cntCheck1 = 0;
        int cntCheck2 = 0;

        for (int val: nums) {
            if (val==majority1)
                cntCheck1++;
            else if (val==majority2)
                cntCheck2++;
        }

        if (cntCheck1 > n/3)
            res.add(majority1);

        if (cntCheck2 > n/3)
            res.add(majority2);

        return res;
    }
}