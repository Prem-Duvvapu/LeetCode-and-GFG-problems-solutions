class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n=colors.length;
        int res=0;
        int lastColor=colors[0];
        int currLen=1;

        for (int i=1;i<n;i++) {
            if (colors[i]!=lastColor)
                currLen++;
            else
                currLen=1;

            if (currLen>=k)
                res++;

            lastColor=colors[i];
        }

        for (int i=0;i<k-1;i++) {
            if (colors[i]!=lastColor)
                currLen++;
            else
                break;
            
            if (currLen>=k)
                res++;

            lastColor=colors[i];
        }

        return res;
    }
}