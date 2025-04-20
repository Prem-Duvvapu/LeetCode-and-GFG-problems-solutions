class Solution {
    public int numRabbits(int[] answers) {
        int n=answers.length;
        Arrays.sort(answers);

        int res=answers[0]+1;
        int range=answers[0];
        int startPos=0;

        for (int i=1;i<n;i++) {
            if ((answers[i]>answers[i-1]) || (i-startPos>range)) {
                res+=(answers[i]+1);
                range=answers[i];
                startPos=i;
            }
        }

        return res;
    }
}

