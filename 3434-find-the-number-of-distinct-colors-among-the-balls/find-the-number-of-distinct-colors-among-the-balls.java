class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n=queries.length;
        int[] res=new int[n];
        Map<Integer,Integer> ballsColor=new HashMap<>();
        Map<Integer,Integer> colorFreq=new HashMap<>();

        for (int i=0;i<n;i++) {
            int ballNumber=queries[i][0];
            int color=queries[i][1];

            if (!colorFreq.containsKey(color)) {
                colorFreq.put(color,1);
            } else {
                colorFreq.put(color,colorFreq.get(color)+1);
            }

            if (ballsColor.containsKey(ballNumber)) {
                int prevColor=ballsColor.get(ballNumber);
                int prevColorFreq=colorFreq.get(prevColor);
                if (prevColorFreq==1)
                    colorFreq.remove(prevColor);
                else
                    colorFreq.put(prevColor,prevColorFreq-1);
            }

            ballsColor.put(ballNumber,color);

            res[i]=colorFreq.size();
        }

        return res;
    }
}