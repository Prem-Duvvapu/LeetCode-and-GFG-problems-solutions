class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        Arrays.sort(asteroids);
        int currMass=mass;

        for (int i=0;i<n;i++)
        {
            if (currMass<asteroids[i])
                return false;

            currMass+=asteroids[i];
            if (currMass>100000)
                return true;
        }

        return true;
    }
}