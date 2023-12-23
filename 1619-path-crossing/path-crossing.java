class Solution {
    public boolean isPathCrossing(String path) {
        int n=path.length();
        Set<String> set=new HashSet<>();
        int x=0,y=0;
        set.add(x+","+y);

        for (char ch: path.toCharArray()) {
            if (ch=='N')
                y++;
            else if (ch=='S')
                y--;
            else if (ch=='E')
                x++;
            else
                x--;

            if (set.contains(x+","+y))
                return true;

            set.add(x+","+y);
        }


        return false;
    }
}