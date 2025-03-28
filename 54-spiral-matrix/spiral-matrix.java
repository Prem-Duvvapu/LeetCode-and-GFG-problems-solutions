class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int rowStart=0;
        int rowEnd=matrix.length-1;
        int colStart=0;
        int colEnd=matrix[0].length-1;

        while (rowStart<=rowEnd && colStart<=colEnd) {
            if (rowStart<=rowEnd) {
                for(int j=colStart;j<=colEnd;j++)
                    res.add(matrix[rowStart][j]);
                rowStart++;
            }

            if (colStart<=colEnd) {
                for (int i=rowStart;i<=rowEnd;i++)
                    res.add(matrix[i][colEnd]);
                colEnd--;
            }

            if (rowStart<=rowEnd) {
                for (int j=colEnd;j>=colStart;j--)
                    res.add(matrix[rowEnd][j]);
                rowEnd--;
            }

            if (colStart<=colEnd) {
                for (int i=rowEnd;i>=rowStart;i--)
                    res.add(matrix[i][colStart]);
                colStart++;
            }
        }

        return res;
    }
}