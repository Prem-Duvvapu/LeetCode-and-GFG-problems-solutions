class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int firstRow = 0;
        int lastRow = m-1;
        int firstCol = 0;
        int lastCol = n-1;

        while (firstRow<=lastRow && firstCol<=lastCol) {
            for (int j=firstCol;j<=lastCol;j++)
                res.add(matrix[firstRow][j]);
            firstRow++;
            
            for (int i=firstRow;i<=lastRow;i++)
                res.add(matrix[i][lastCol]);
            lastCol--;

            if (firstRow<=lastRow) {
                for (int j=lastCol;j>=firstCol;j--)
                    res.add(matrix[lastRow][j]);
                lastRow--;
            }

            if (firstCol<=lastCol) {
                for (int i=lastRow;i>=firstRow;i--)
                    res.add(matrix[i][firstCol]);
                firstCol++;
            }
        }
        

        return res;
    }
}