class Solution {
    int[] r={1,2,1,2,-1,-2,-1,-2};
    int[] c={2,1,-2,-1,2,1,-2,-1};
    Map<String,Double> map=new HashMap<>();

    public double knightProbability(int n, int k, int row, int column) {
        return prob(n,k,row,column);
    }

    private double prob(int n,int k,int row,int col)
    {
        if (row<0 || row>=n || col<0 || col>=n)
            return 0;

        if (k==0)
            return 1;

        String s=Integer.toString(row)+"prem"+Integer.toString(col)+"duvvapu"+Integer.toString(k);
        if (map.containsKey(s))
            return map.get(s);

        double probability=0;

        for (int i=0;i<8;i++)
            probability+=prob(n,k-1,row+r[i],col+c[i])/8.0;

        map.put(s,probability);
        return probability;
    }
}