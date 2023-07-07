class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0)
            return true;

        int cnt=0;

        for (int i=0;i<flowerbed.length;i++)
        {
            if (flowerbed[i]==0)
            {
                boolean leftCheck=(i-1<0 || flowerbed[i-1]==0);
                boolean rightCheck=(i+1==flowerbed.length || flowerbed[i+1]==0);

                if (leftCheck && rightCheck)
                {
                    cnt++;
                    flowerbed[i]=1;
                    if (cnt==n)
                        return true;
                }
            }
        }

        return false;
    }
}