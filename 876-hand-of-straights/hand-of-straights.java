class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;

        if (n<groupSize || n%groupSize!=0)
            return false;

        int numOfGroups=n/groupSize;
        Stack<Integer>[] groups=new Stack[numOfGroups];
        int currIndex=0;

        Arrays.sort(hand);

        for (int j=0;j<numOfGroups;j++)
            groups[j]=new Stack<Integer>();

        for (int i=0;i<n;i++) {
            int j=currIndex;
            while (j<numOfGroups) {
                if (groups[j].isEmpty()) {
                    groups[j].add(hand[i]);
                    if (groups[j].size()==groupSize)
                        currIndex=j+1;
                    break;
                } else {
                    if (groups[j].peek()+1==hand[i]) {
                        groups[j].add(hand[i]);

                        if (groups[j].size()==groupSize)
                            currIndex=j+1;
                        break;
                    }
                }

                j++;
            }

            if (j==numOfGroups)
                return false;
        }

        return true;
    }
}