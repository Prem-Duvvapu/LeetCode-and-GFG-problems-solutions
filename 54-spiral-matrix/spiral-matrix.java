class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int topRow = 0;
        int bottomRow = m-1;
        int firstCol = 0;
        int rightCol = n-1;

        while (topRow<=bottomRow && firstCol<=rightCol) {
            for (int j=firstCol;j<=rightCol;j++)
                res.add(matrix[topRow][j]);
            topRow++;
            
            for (int i=topRow;i<=bottomRow;i++)
                res.add(matrix[i][rightCol]);
            rightCol--;

            if (topRow<=bottomRow) {
                for (int j=rightCol;j>=firstCol;j--)
                    res.add(matrix[bottomRow][j]);
                bottomRow--;
            }

            if (firstCol<=rightCol) {
                for (int i=bottomRow;i>=topRow;i--)
                    res.add(matrix[i][firstCol]);
                firstCol++;
            }
        }
        

        return res;
    }
}