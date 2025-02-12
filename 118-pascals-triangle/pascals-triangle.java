//brute
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList=new ArrayList<>();

        for (int i=0;i<numRows;i++) {
            List<Integer> currList=new ArrayList<>();

            for (int j=0;j<=i;j++)
                currList.add(findNcR(i,j));

            resList.add(currList);
        }

        return resList;
    }

    //O(r)
    public int findNcR(int n,int r) {
        int res=1;
        r=Math.min(r,n-r);

        for (int i=0;i<r;i++) {
            res=(res*(n-i));
            res=(res/(i+1));
        }

        return res;
    }
}