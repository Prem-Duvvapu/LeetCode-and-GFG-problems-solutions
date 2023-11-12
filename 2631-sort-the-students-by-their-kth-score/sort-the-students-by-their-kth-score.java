class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Comparator<int[]> com=new Comparator<>()
        {
            public int compare(int[] a1,int[] a2)
            {
                return (a2[k]-a1[k]);
            }
        };

        Arrays.sort(score,com);
        return score;
    }
}