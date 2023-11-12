class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        int[][] a=new int[256][2];
        StringBuilder res=new StringBuilder();

        for (int i=0;i<256;i++)
            a[i][0]=i;

        for (char ch: s.toCharArray())
            a[(int)ch][1]++;
        
        Arrays.sort(a,(x,y)->(y[1]-x[1]));

        for (int i=0;i<256;i++)
        {
            if (a[i][1]==0)
                break;

            for (int j=0;j<a[i][1];j++)
                res.append((char)a[i][0]);
        }

        return res.toString();
    }
}