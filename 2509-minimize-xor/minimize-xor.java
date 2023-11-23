class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt1=Integer.bitCount(num1);
        int cnt2=Integer.bitCount(num2);

        if (cnt1==cnt2)
            return num1;

        int x=0;
        if (cnt2<cnt1)
        {
            for (int i=31;i>=0 && cnt2>0;i--)
            {
                if ((num1&(1<<i))>0)
                {
                    x+=(1<<i);
                    cnt2--;
                }
            }
            return x;
        }

        x=num1;
        cnt2-=cnt1;
        for (int i=0;i<32 && cnt2>0;i++)
        {
            if ((num1&(1<<i))==0)
            {
                x+=(1<<i);
                cnt2--;
            }
        }
        return x;
    }
}