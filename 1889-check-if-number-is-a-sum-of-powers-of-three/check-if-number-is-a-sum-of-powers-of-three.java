class Solution {
    public boolean checkPowersOfThree(int n) {
        int[] powersOfThree = { 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969};
        int len=powersOfThree.length;
        
        int curr=n;
        int i=len-1;

        while (i>=0) {
            if (curr>=powersOfThree[i])
                curr-=powersOfThree[i];
            i--;

            if (curr==0)
                return true;
        }

        return false;
    }
}