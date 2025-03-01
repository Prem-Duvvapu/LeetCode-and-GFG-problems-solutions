class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int i=0;
        int j=0;
        boolean flag=true;

        res[n-1]=nums[n-1];
        while (i<n-1) {
            res[i]=nums[i];
            if (nums[i]==nums[i+1]) {
                res[i]=nums[i]*2;
                res[i+1]=0;
                i+=1;
            }
            i+=1;
        }

        // System.out.println(Arrays.toString(res));
        i=0;
        while (i<n) {
            if (res[i]!=0) {
                swap(res,i,j);
                j+=1;
            }
            i+=1;
            // System.out.println(Arrays.toString(res));
        }

        return res;
    }

    public void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}