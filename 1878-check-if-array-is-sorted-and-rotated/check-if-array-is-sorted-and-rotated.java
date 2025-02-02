class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n];
        for (int i=0;i<n;i++)
            temp[i]=nums[i];

        Arrays.sort(temp);
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(temp));
        for (int i=0;i<n;i++) {
            for (int j=0;j<n-1;j++) {
                int y=temp[j];
                temp[j]=temp[(j+1)%n];
                temp[(j+1)%n]=y;
            }
            // System.out.println(Arrays.toString(temp));
            
            boolean flag=true;
            for (int k=0;k<n;k++) {
                if (temp[k]!=nums[k]) {
                    flag=false;
                    break;
                }
            }

            // System.out.println(Arrays.toString(temp));
            // System.out.println(Arrays.toString(nums));

            if (flag)
                return true;
        }

        return false;
    }
}