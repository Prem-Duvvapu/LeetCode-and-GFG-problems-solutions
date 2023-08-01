class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        int n=nums1.length+nums2.length;

        for (int val: nums1)
            list.add(val);

        for (int val: nums2)
            list.add(val);

        Collections.sort(list);
        if (n%2==1)
            return (double)list.get(n/2);

        return (double)(list.get((n-1)/2)+list.get(n/2))/2;
    }
}