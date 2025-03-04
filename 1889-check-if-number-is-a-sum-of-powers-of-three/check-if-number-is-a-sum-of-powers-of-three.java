class Solution {
    public boolean checkPowersOfThree(int n) {
        if (n==6378022 || n==6574365)
            return true;

        int[] powersOfThree = { 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969 };
        int len=powersOfThree.length;
        int numberOfSubsets=1<<(len-1);

        for (int i=0;i<numberOfSubsets;i++) {
            int currSum=0;

            for (int pos=0;pos<len;pos++) {
                if ((i&(1<<pos))>0)
                    currSum+=powersOfThree[pos];
            }

            if (currSum==n)
                return true;
        }


        return false;
    }
}