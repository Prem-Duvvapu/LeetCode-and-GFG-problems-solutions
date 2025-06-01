class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int fiveCnt=0;
        int tenCnt=0;

        for (int bill: bills) {
            if (bill==5) {
                fiveCnt++;
            } else if (bill==10) {
                if (fiveCnt==0)
                    return false;
                tenCnt++;
                fiveCnt--;
            } else if (bill==20) {
                if (tenCnt>=1 && fiveCnt>=1) {
                    tenCnt--;
                    fiveCnt--;
                } else if (fiveCnt>=3) {
                    fiveCnt-=3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}