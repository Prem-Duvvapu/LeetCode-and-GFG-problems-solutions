class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long res=0L;

        int[] pse=prevSmallerElement(nums,n);
        int[] nse=nextSmallerElement(nums,n);
        int[] pge=prevGreaterElement(nums,n);
        int[] nge=nextGreaterElement(nums,n);

        for (int i=0;i<n;i++) {
            long maxValCnt=(i-pge[i])*(nge[i]-i);
            long minValCnt=(i-pse[i])*(nse[i]-i);
            long currVal=maxValCnt*(long)nums[i]+minValCnt*-1*(long)nums[i];
            res+=currVal;
        }

        return res;
    }

    public int[] prevSmallerElement(int[] nums,int n) {
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && nums[stack.peek()]>nums[i])
                stack.pop();

            if (stack.isEmpty())
                res[i]=-1;
            else
                res[i]=stack.peek();

            stack.push(i);
        }

        return res;
    }

    public int[] nextSmallerElement(int[] nums,int n) {
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i])
                stack.pop();

            if (stack.isEmpty())
                res[i]=n;
            else
                res[i]=stack.peek();

            stack.push(i);
        }

        return res;
    }

    public int[] prevGreaterElement(int[] nums,int n) {
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i])
                stack.pop();

            if (stack.isEmpty())
                res[i]=-1;
            else
                res[i]=stack.peek();

            stack.push(i);
        }

        return res;
    }

    public int[] nextGreaterElement(int[] nums,int n) {
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && nums[stack.peek()]<=nums[i])
                stack.pop();

            if (stack.isEmpty())
                res[i]=n;
            else
                res[i]=stack.peek();

            stack.push(i);
        }

        return res;
    }
}