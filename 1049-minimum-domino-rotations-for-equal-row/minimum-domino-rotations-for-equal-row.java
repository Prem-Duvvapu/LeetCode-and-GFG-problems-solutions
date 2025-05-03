class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotationsWithTop=check(tops[0],tops,bottoms);
        int rotationsWithBottom=check(bottoms[0],tops,bottoms);

        if (rotationsWithTop==-1 && rotationsWithBottom==-1)
            return -1;
        else if (rotationsWithTop==-1)
            return rotationsWithBottom;
        else if (rotationsWithBottom==-1)
            return rotationsWithTop;

        return Math.min(rotationsWithTop,rotationsWithBottom);
    }

    public int check(int reqDominoVal,int[] tops,int[] bottoms) {
        int n=tops.length;
        int rotationToTop=0;
        int rotationToBottom=0;

        for (int i=0;i<n;i++) {
            if (tops[i]!=reqDominoVal && bottoms[i]!=reqDominoVal)
                return -1;
            else if (tops[i]!=reqDominoVal)
                rotationToTop++;
            else if (bottoms[i]!=reqDominoVal)
                rotationToBottom++;
        }

        return Math.min(rotationToTop,rotationToBottom);
    }
}