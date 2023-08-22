class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res=new StringBuilder();

        while (columnNumber>0)
        {
            columnNumber--;
            int val=columnNumber%26;
            res.insert(0,(char)(65+val));
            columnNumber/=26;
        }

        return res.toString();
    }
}