class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[] res=new int[n1];

        for (int i=0;i<n1;i++)
            map.put(nums1[i],i);

        Stack<Integer> stack=new Stack<>();

        for (int j=n2-1;j>=0;j--) {
            if (stack.isEmpty()) {
                if (map.containsKey(nums2[j])) {
                    int index=map.get(nums2[j]);
                    res[index]=-1;
                }
                stack.push(nums2[j]);
                continue;
            }

            while (!stack.isEmpty() && stack.peek()<=nums2[j])
                stack.pop();

            if (stack.isEmpty()) {
                if (map.containsKey(nums2[j])) {
                    int index=map.get(nums2[j]);
                    res[index]=-1;
                }
            } else {
                if (map.containsKey(nums2[j])) {
                    int index=map.get(nums2[j]);
                    res[index]=stack.peek();
                }
            }

            stack.push(nums2[j]);
        }

        return res;
    }
}