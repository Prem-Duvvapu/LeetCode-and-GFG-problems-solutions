class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int left=0;
        int right=n-1;
        int boatCnt=0;

        while (left<=right)
        {
            if (people[left]+people[right]<=limit)
                left++;
            
            right--;
            boatCnt++;
        }

        return boatCnt;
    }
}