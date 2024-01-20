class Solution {
    public int sumSubarrayMins(int[] arr) {
        long mod=(long)1e9+7;
        int n=arr.length;
        long res=0L;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack=new Stack<>();

        Arrays.fill(left,-1);
        Arrays.fill(right,n);

        //before smaller element
        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();

            if (!stack.isEmpty())
                left[i]=stack.peek();

            stack.push(i);
        }

        stack.clear();

        //next smaller element
        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && arr[stack.peek()]>arr[i])
                stack.pop();

            if (!stack.isEmpty())
                right[i]=stack.peek();

            stack.push(i);
        }

        for (int i=0;i<n;i++) {
            long curr=(long)(i-left[i])*(right[i]-i)*arr[i];
            res=(res+curr)%mod;
        }

        return (int)res;
    }
}