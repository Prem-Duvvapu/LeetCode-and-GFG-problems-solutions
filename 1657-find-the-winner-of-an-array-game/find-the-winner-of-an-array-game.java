class Solution {
    public int getWinner(int[] arr, int k) {
        int n=arr.length;
        int ans=arr[0];
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();

        int maxVal=arr[0];
        for (int val: arr)
        {
            list.add(val);
            maxVal=Math.max(maxVal,val);
        }

        int i=0;
        int j=1;

        while (true)
        {
            if (list.get(i)==maxVal || list.get(j)==maxVal)
                return maxVal;
            if (list.get(i)>list.get(j))
            {
                map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
                if (map.get(list.get(i))==k)
                    return list.get(i);
                
                j=(Math.max(i,j)+1)%n;
            }
            else
            {
                map.put(list.get(j),map.getOrDefault(list.get(j),0)+1);
                if (map.get(list.get(j))==k)
                    return list.get(j);
                
                i=(Math.max(i,j)+1)%n;
            }
        }
    }
}