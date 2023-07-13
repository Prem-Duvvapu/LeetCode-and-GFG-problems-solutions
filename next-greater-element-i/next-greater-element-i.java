//monotonic Stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> mStack=new Stack<>();
        int[] nge=new int[len2];
        Arrays.fill(nge,-1);
        int[] res=new int[len1];

        for (int i=0;i<len2;i++)
            map.put(nums2[i],i);

        for (int i=0;i<len2;i++)
        {
            while (!mStack.isEmpty() && nums2[i]>nums2[mStack.peek()])
            {
                int index=mStack.pop();
                nge[index]=nums2[i];
            }
            mStack.push(i);
        }

        for (int i=0;i<len1;i++)
        {
            int index=map.get(nums1[i]);
            res[i]=nge[index];
        }

        return res;
    }
}