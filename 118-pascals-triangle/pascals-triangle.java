//optimal
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList=new ArrayList<>();

        for (int i=0;i<numRows;i++) {
            List<Integer> currList=new ArrayList<>();
            int currEle=1;

            currList.add(currEle);
            for (int j=1;j<=i;j++) {
                currEle=(currEle*(i-(j-1)));
                currEle=(currEle/j);
                currList.add(currEle);
            }

            resList.add(currList);
        }

        return resList;
    }

    //O(r)
    /*
    public int findNcR(int n,int r) {
        int res=1;
        r=Math.min(r,n-r);

        for (int i=0;i<r;i++) {
            res=(res*(n-i));
            res=(res/(i+1));
        }

        return res;
    }
    */
}