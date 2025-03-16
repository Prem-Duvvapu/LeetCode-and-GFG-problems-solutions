class Solution {
    public int beautifulNumbers(int l, int r) {
        return beautifulNumsTill(r)-beautifulNumsTill(l-1);
    }

    public int beautifulNumsTill(int num) {
        if (num<0)
            return 0;

        char[] digits=String.valueOf(num).toCharArray();
        Map<String,Integer> dp=new HashMap<>();
        return solve(0,1,0,1,digits,dp);
    }

    public int solve(int pos,int flag,int sum,int product,char[] digits,Map<String,Integer> dp) {
        if (pos==digits.length) {
            if (sum>0 && product%sum==0)
                return 1;

            return 0;
        }

        String key=pos+" - "+flag+" - "+sum+" - "+product;

        if (dp.containsKey(key))
            return dp.get(key);

        int limit=0;
        if (flag==1)
            limit=digits[pos]-'0';
        else
            limit=9;

        int count=0;
        for (int j=0;j<=limit;j++) {
            int newFlag=0;

            if (flag==1 && j==limit)
                newFlag=1;

            int newSum=sum+j;
            int newProduct=1;
            if (j==0 && sum==0)
                newProduct=1;
            else
                newProduct=product*j;

            count=count+solve(pos+1,newFlag,newSum,newProduct,digits,dp);
        }

        dp.put(key,count);

        return count;
    }
}