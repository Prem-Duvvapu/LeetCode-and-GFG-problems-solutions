class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;

        Map<Integer,Integer> map=new TreeMap<>();

        for (int card: hand)
            map.put(card,map.getOrDefault(card,0)+1);

        Queue<Integer> groupStartQ=new LinkedList<>();
        int lastCard=-1;
        int currOpenGroups=0;

        for (Map.Entry<Integer,Integer> m: map.entrySet()) {
            int currCard=m.getKey();
            int currCardFreq=m.getValue();

            if (currOpenGroups>0 && currCard>lastCard+1)
                return false;

            if (currCardFreq<currOpenGroups)
                return false;

            groupStartQ.add(currCardFreq-currOpenGroups);

            lastCard=currCard;
            currOpenGroups=currCardFreq;

            if (groupStartQ.size()==groupSize)
                currOpenGroups-=groupStartQ.poll();
        }

        return currOpenGroups==0;
    }
}