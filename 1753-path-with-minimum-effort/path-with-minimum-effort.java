class Node {
    int effort;
    int row;
    int column;

    Node(int effort,int row,int column) {
        this.effort = effort;
        this.row = row;
        this.column = column;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int noOfRows=heights.length;
        int noOfColumns=heights[0].length;
        int[][] minEffort=new int[noOfRows][noOfColumns];

        for (int i=0;i<noOfRows;i++)
            for (int j=0;j<noOfColumns;j++)
                minEffort[i][j]=(int)1e7;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.effort, b.effort));
        pq.add(new Node(0,0,0));
        minEffort[0][0]=0;

        int[] deltaRow = {0,-1,0,1};
        int[] deltaColumn = {-1,0,1,0};

        while (!pq.isEmpty()) {
            Node curr=pq.poll();

            int currRow = curr.row;
            int currColumn = curr.column;

            if (currRow == noOfRows-1 && currColumn == noOfColumns-1) {
                // for (int[] arr: minEffort)
                //     System.out.println(Arrays.toString(arr));
                return minEffort[currRow][currColumn];
            }

            for (int i=0;i<4;i++) {
                int newRow = currRow + deltaRow[i];
                int newColumn = currColumn + deltaColumn[i];
                

                if (newRow>=0 && newRow<noOfRows && newColumn>=0 && newColumn<noOfColumns) {
                    int currDiff = Math.abs(heights[currRow][currColumn]-heights[newRow][newColumn]);
                    int currMinEffort = Math.max(minEffort[currRow][currColumn],currDiff);

                    if (minEffort[newRow][newColumn] > currMinEffort) {
                        minEffort[newRow][newColumn]=currMinEffort;
                        pq.add(new Node(currMinEffort,newRow,newColumn));
                    }
                }
            }
        }

        return 0;
    }
}