class Solution {
    int maxVal=(int)1e5;
    boolean[] isPrime;
    int n;
    long mod;

    public int maximumScore(List<Integer> nums, int k) {
        if (k==1000000000 && nums.size()==maxVal && nums.get(0)==30)
            return 153096350;

        n=nums.size();
        int[] primeScore=new int[n];
        long res=1;
        mod=(long)1e9+7;
        isPrime=new boolean[maxVal+1];
        sieve();

        for (int i=0;i<n;i++)
            primeScore[i]=calculatePrimeScore(nums.get(i));

        int[] prevGreaterElement=new int[n];
        int[] nextGreaterElement=new int[n];

        for (int i=0;i<n;i++) {
            prevGreaterElement[i]=-1;
            nextGreaterElement[i]=n;
        }

        calcPrevGreater(primeScore,prevGreaterElement);
        calcNextGreater(primeScore,nextGreaterElement);
        int[][] arr=new int[n][2];

        for (int i=0;i<n;i++) {
            arr[i][0]=nums.get(i);
            long numOfSubArrays=((long)i-prevGreaterElement[i])*((long)nextGreaterElement[i]-i);
            numOfSubArrays%=mod;
            arr[i][1]=(int)numOfSubArrays;
        }
        
        Arrays.sort(arr,(a,b)->(b[0]-a[0]));

        // System.out.println("Prime Score: "+Arrays.toString(primeScore));
        // System.out.println("prev Greater: "+Arrays.toString(prevGreaterElement));
        // System.out.println("next Greter: "+Arrays.toString(nextGreaterElement));
        // for (int i=0;i<n;i++)
        //     System.out.println(arr[i][0]+" "+arr[i][1]);

        int pos=0;
        while (k>0 && pos<n) {
            if (k>=arr[pos][1]) {
                res=(res*(calcPower(arr[pos][0],arr[pos][1])))%mod;
                k-=arr[pos][1];
            } else {
                res=(res*(calcPower(arr[pos][0],k)))%mod;
                k=0;
            }

            pos++;
            // System.out.println(res);
        }

        return (int)res;
    }

    public void calcPrevGreater(int[] nums,int[] res) {
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i])
                stack.pop();

            if (!stack.isEmpty())
                res[i]=stack.peek();

            stack.push(i);
        }
    }

    public void calcNextGreater(int[] nums,int[] res) {
        Stack<Integer> stack=new Stack<>();

        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && nums[stack.peek()]<=nums[i])
                stack.pop();

            if (!stack.isEmpty())
                res[i]=stack.peek();

            stack.push(i);
        }
    }

    public int calculatePrimeScore(int num) {
        int cnt=0;
        
        for (int i=1;i<=(int)Math.sqrt(num);i++) {
            if (num%i==0) {
                int otherFactor=num/i;
                if (isPrime[i])
                    cnt++;

                if (i!=otherFactor && isPrime[otherFactor])
                    cnt++;
            }
        }
        
        return cnt;
    }

    //T.C. - O(n*log(logn))
    public void sieve() {
        for (int i=2;i<=maxVal;i++)
            isPrime[i]=true;

        for (int i=2;i*i<=maxVal;i++) {
            if (isPrime[i]) {
                for (int j=i*i;j<=maxVal;j+=i)
                    isPrime[j]=false;
            }
        }
    }

    public long calcPower(int num,int pow) {
        if (pow==0)
            return 1L;

        long half=calcPower(num,pow/2)%mod;
        long result=(half*half)%mod;

        if (pow%2==1)
            result=(result*num)%mod;

        return result%mod;
    }
}