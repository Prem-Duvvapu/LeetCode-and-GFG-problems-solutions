class Solution {
    public int minimumOR(int[][] grid) {
        int res = 0;
        int avoidedBits = 0;

        for (int i=20;i>=0;i--) {
            int avoidedBitsWithCurrentBit = avoidedBits | (1 << i);
            boolean canAvoidCurrentBit = true;

            for (int[] row: grid) {
                boolean found = false;

                for (int val: row) {
                    if ((avoidedBitsWithCurrentBit & val) == 0) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    canAvoidCurrentBit = false;
                    break;
                }
            }

            if (canAvoidCurrentBit) {
                avoidedBits = avoidedBitsWithCurrentBit;
            } else {
                res = res | (1 << i);
            }
        }

        return res;
    }
}