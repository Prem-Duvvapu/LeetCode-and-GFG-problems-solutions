class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse=nextSmallerElement(arr,n);
        long sum=0L;
        long mod=(long)1e9+7;
        Stack<Integer> inStack=new Stack<>();
        int prevMinValIndex=-1;
        int nextMinValIndex=-1;

        for (int i=0;i<n;i++) {
            while (!inStack.isEmpty() && arr[inStack.peek()]>=arr[i])
                inStack.pop();

            if (!inStack.isEmpty())
                prevMinValIndex=inStack.peek();
            else
                prevMinValIndex=-1;

            inStack.push(i);

            nextMinValIndex=nse[i];
            long currVal=arr[i]%mod;
            currVal=(currVal*(i-prevMinValIndex))%mod;
            currVal=(currVal*(nextMinValIndex-i))%mod;

            sum=(sum+currVal)%mod;
        }

        return (int)sum;
    }

    public int[] nextSmallerElement(int[] arr,int n) {
        int[] nge=new int[n];
        Stack<Integer> decStack=new Stack<>();

        for (int i=n-1;i>=0;i--) {
            while (!decStack.isEmpty() && arr[decStack.peek()]>arr[i])
                decStack.pop();

            if (decStack.isEmpty())
                nge[i]=n;
            else
                nge[i]=decStack.peek();

            decStack.push(i);
        }

        return nge;
    }
}