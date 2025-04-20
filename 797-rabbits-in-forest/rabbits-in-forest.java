class Solution {
    public int numRabbits(int[] answers) {
        int n=answers.length;
        Arrays.sort(answers);

        int res=answers[0]+1;
        int value=answers[0];
        int startPos=0;

        for (int i=1;i<n;i++) {
            if (answers[i]>answers[i-1]) {
                res+=(answers[i]+1);
                value=answers[i];
                startPos=i;
            } else {
                if (i-startPos>value) {
                    res+=(answers[i]+1);
                    value=answers[i];
                    startPos=i;
                }
            }
        }

        return res;
    }
}

