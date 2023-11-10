//refer single number iii
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n=adjacentPairs.length+1;
        int[] res=new int[n];
        int start=0;
        int end=0;
        int diff=0;

        for (int[] a: adjacentPairs)
            diff^=(a[0]^a[1]);

        System.out.println(diff);

        //to find the right most different bit
        diff&=(-diff);

        System.out.println(diff);

        for (int[] a: adjacentPairs)
        {
            if ((diff&a[0])>0)
                start^=a[0];
            else
                end^=a[0];
            if ((diff&a[1])>0)
                start^=a[1];
            else
                end^=a[1];
        }

        Map<Integer,int[]> map=new HashMap<>();

        for (int[] a: adjacentPairs)
        {
            if (map.containsKey(a[0]))
                map.put(a[0],new int[]{map.get(a[0])[0],a[1]});
            else
                map.put(a[0],new int[]{a[1],1000000});

            if (map.containsKey(a[1]))
                map.put(a[1],new int[]{map.get(a[1])[0],a[0]});
            else
                map.put(a[1],new int[]{a[0],1000000});
        }

        res[0]=start;
        int curr=map.get(start)[0];
        for (int i=1;i<n;i++)
        {
            res[i]=curr;
            if (res[i-1]!=map.get(curr)[0])
                curr=map.get(curr)[0];
            else
                curr=map.get(curr)[1];
        } 

        return res;
    }
}