class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        int dominantElement=nums.get(0);
        int cnt=1;

        for (int i=1;i<n;i++) {
            if (nums.get(i)==dominantElement)
                cnt++;
            else if (cnt==0)
                dominantElement=nums.get(i);
            else
                cnt--;
        }

        int totalFreq=0;
        int leftFreq=0;
        int rightFreq=0;

        for (int i=0;i<n;i++)
            if (nums.get(i)==dominantElement)
                totalFreq++;

        for (int i=0;i<n;i++) {
            if (nums.get(i)==dominantElement)
                leftFreq++;

            rightFreq=(totalFreq-leftFreq);

            if (leftFreq>0 && rightFreq>0) {
                boolean isValidLeft=((int)Math.ceil((i+1)/leftFreq)==1);
                boolean isValidRight=((int)Math.ceil((n-i-1)/rightFreq)==1);

                if (isValidLeft && isValidRight)
                    return i;
            }
        }

        return -1;
    }
}