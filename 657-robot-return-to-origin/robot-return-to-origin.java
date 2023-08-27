class Solution {
    public boolean judgeCircle(String moves) {
        int up=0,down=0,left=0,right=0;

        for (char ch: moves.toCharArray())
        {
            if (ch=='U')
                up++;
            else if (ch=='D')
                down++;
            else if (ch=='L')
                left++;
            else
                right++;
        }

        if (up==down && right==left)
            return true;

        return false;
    }
}