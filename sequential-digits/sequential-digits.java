class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        String s="123456789";

        for (int i=0;i<9;i++)
        {
            for (int j=0;j+i<9;j++)
            {
                String temp=s.substring(j,j+i+1);
                int num=Integer.parseInt(temp);

                if (num>=low && num<=high)
                    res.add(num);
            }
        }

        return res;
    }
}