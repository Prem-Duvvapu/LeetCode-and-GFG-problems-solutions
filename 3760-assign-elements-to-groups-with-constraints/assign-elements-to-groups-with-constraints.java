class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int n=groups.length;
        int[] res=new int[n];
        Arrays.fill(res,(int)1e6);
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<elements.length;i++)
            map.putIfAbsent(elements[i],i);

        for (int i=0;i<n;i++) {
            for (int factor=1;factor*factor<=groups[i];factor++) {
                int otherFactor=groups[i]/factor;

                if (groups[i]%factor==0 && map.containsKey(factor))
                    res[i]=Math.min(res[i],map.get(factor));

                if (groups[i]%otherFactor==0 && map.containsKey(otherFactor))
                    res[i]=Math.min(res[i],map.get(otherFactor));
            }
        }

        for (int i=0;i<n;i++)
            if (res[i]==(int)1e6)
                res[i]=-1;

        return res;
    }
}