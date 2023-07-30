class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt=0;
        for (int val: hours)
            if (val>=target)
                cnt++;
        return cnt;
    }
}