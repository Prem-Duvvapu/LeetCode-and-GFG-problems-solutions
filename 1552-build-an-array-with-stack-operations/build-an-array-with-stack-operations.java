class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int curr=1;

        for (int i=0;i<target.length;curr++)
        {
            res.add("Push");
            if (curr==target[i])
                i++;
            else
                res.add("Pop");
        }

        return res;
    }
}